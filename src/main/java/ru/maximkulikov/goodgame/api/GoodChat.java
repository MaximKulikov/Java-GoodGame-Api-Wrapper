package ru.maximkulikov.goodgame.api;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.chatmodels.*;

/**
 * Ключевой класс библиотеки для работы с чатом GoodGame
 *
 * @author Maxim Kulikov
 */
public abstract class GoodChat {

    protected static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String DEFAULT_CHAT_URL = "ws://chat.goodgame.ru:8081/chat/websocket";
    private Logger logger = LoggerFactory.getLogger(GoodChat.class);
    private GoodChatSocket socket;

    private WebSocketClient client;

    private boolean connected;

    /**
     * Подключается к websocket серверу чата GoodGame и держит подключение в течение 24 часов. Необходима остановка
     * потока вручную
     *
     * @throws Exception Исключение возможно в отдельном потоке при подключении или попутки закрыть соедиение
     * @see #stop()
     */
    public final void connect() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GoodChat.this.client = new WebSocketClient();
                GoodChat.this.socket = new GoodChatSocket();
                try {
                    GoodChat.this.client.start();
                    URI echoUri = new URI(DEFAULT_CHAT_URL);
                    ClientUpgradeRequest request = new ClientUpgradeRequest();
                    GoodChat.this.client.connect(GoodChat.this.socket, echoUri, request);
                    logger.info("Connecting to: {}", echoUri);

                    GoodChat.this.socket.setChat(GoodChat.this);
                    GoodChat.this.socket.awaitClose(24, TimeUnit.HOURS);

                } catch (Exception e) {
                    logger.error("Connecting exeption: {}", e.getLocalizedMessage());
                    e.printStackTrace();
                } finally {
                    try {
                        GoodChat.this.client.stop();
                    } catch (Exception e) {
                        logger.error("Close connecting exeption: {}", e.getLocalizedMessage());
                    }
                }
            }
        }).start();
    }

    /**
     * @return Возвражает статус подключения к серверу чату.
     */
    public final boolean isConnected() {
        return this.connected;
    }

    /**
     * @param connected Устанавливает статус подключения к серверу чата.
     */
    public final void setConnected(final boolean connected) {
        this.connected = connected;
    }

    /**
     * Этот метод вызывается пришедшим от сервера чата ответом в любое время. В ответе приходит тип сообщения из
     * перечисления ChatResponses и сам объект ответа или null, если пришел ответ неизвестного типа. <br><br> Пример обработки ответа<br>
     * <p>
     * public void onMessage(Response answer) {<br> <br> // Возвращает значение Enum с типом пришедшего сообщения<br>
     * answer.getType();<br> <br> // Возвращает базовый ResChatObject<br> answer.getAnswer();<br> <br> switch
     * (answer.getType()) {<br> case CHANNEL_HISTORY:<br> ResChannelHistory resChannelHistory = (ResChannelHistory)
     * answer.getAnswer();<br> System.out.println(answer.getAnswer());<br> }<br>
     *
     * @param answer Ответ от сервера чата
     * @see ChatResponses
     * @see Response
     */
    public abstract void onMessage(final Response answer);

    /**
     * Отправка сообщения в чат. Если сокет не подключен, то ждем 700ms, потом пробуем снова. Если сокет все еще не
     * подключен, то передаем ошибку в метод onMessage
     *
     * @param chatObject
     * @throws InterruptedException
     * @throws JsonProcessingException
     */
    public final void sendMessage(final ReqChatObject chatObject) {

        if (this.socket == null) {
            try {
                Thread.sleep(700);

            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error("Send message Exeption. Closing thread: {}", e.getLocalizedMessage());
                Thread.currentThread().interrupt();
            }
        }

        if (this.socket != null) {

            ObjectMapper mapper = new ObjectMapper();

            try {
                this.socket.sendMessage(mapper.writeValueAsString(chatObject));
            } catch (JsonProcessingException e) {
                logger.error("Json Proccessing exeption: {}", e.getLocalizedMessage());
            }
        } else {
            logger.warn("GoodGameChat not connected proper, Message did not send");
            ResError error = new ResError();

            error.setErrorNum(0);
            error.setErrorMsg("GoodGameChat not connected proper, Message did not send");
            this.onMessage(new Response(ChatResponses.ERROR, error));
        }
    }

    /**
     * Попытка остановить запущенное подключение к серверу чата
     *
     * @throws Exception
     */

    public final void stop() {
        if (this.connected) {
            try {
                GoodChat.this.client.stop();
            } catch (Exception e) {
                logger.error("GoddChat dit not stop in proper way! {}", e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Класс, в котором происходит непосредственное общение с websocket сервером чата GoodGame. Вызывать методы к даном
     * классе категорически не рекомендуется
     */
    @WebSocket(maxTextMessageSize = 64 * 1024)
    public class GoodChatSocket {

        protected final ObjectMapper objectMapper = new ObjectMapper();

        private final CountDownLatch closeLatch;

        private Session session;

        private GoodChat chat = GoodChat.this;

        public GoodChatSocket() {
            this.closeLatch = new CountDownLatch(1);
        }

        public final boolean awaitClose(final int duration, final TimeUnit unit) throws InterruptedException {
            return this.closeLatch.await(duration, unit);
        }

        public final void close() {
            this.session.close(StatusCode.NORMAL, "Session close");
            this.chat.setConnected(false);
        }

        @OnWebSocketClose
        public final void onClose(final int statusCode, final String reason) {
            logger.warn("Connection closed: {} - {}", statusCode, reason);
            this.session = null;
            this.closeLatch.countDown();
        }

        @OnWebSocketConnect
        public final void onConnect(final Session session) {
            logger.info("Got connect: {}", session);
            this.session = session;
            this.chat.setConnected(true);
        }

        @OnWebSocketMessage
        public final void onMessage(final String msg) {
            Response answer;
            try {
                ObjectMapper mapper = new ObjectMapper();
                String type = mapper.readTree(msg).get("type").asText();
                ChatResponses response = ChatResponses.valueOf(type.toUpperCase());

                switch (response) {
                    case ACCEPTED:
                        ResAcceptedContainer resAcceptedContainer =
                                this.objectMapper.readValue(msg, ResAcceptedContainer.class);
                        answer = new Response(response, resAcceptedContainer.getData());
                        break;
                    case WELCOME:
                        ResWelcomeContainer resWelcomeContainer =
                                this.objectMapper.readValue(msg, ResWelcomeContainer.class);
                        answer = new Response(response, resWelcomeContainer.getData());
                        break;
                    case SUCCESS_AUTH:
                        ResAutorizationContainer resAutorizationContainer =
                                this.objectMapper.readValue(msg, ResAutorizationContainer.class);
                        answer = new Response(response, resAutorizationContainer.getData());
                        break;
                    case CHANNELS_LIST:
                        ResChannelsListContainer resChannelsListContainer =
                                this.objectMapper.readValue(msg, ResChannelsListContainer.class);
                        answer = new Response(response, resChannelsListContainer.getData());
                        break;
                    case SUCCESS_JOIN:
                        ResJoinContainer resJoinContainer =
                                this.objectMapper.readValue(msg, ResJoinContainer.class);
                        answer = new Response(response, resJoinContainer.getData());
                        break;
                    case SUCCESS_UNJOIN:
                        ResUnjoinContainer resUnjoinContainer =
                                this.objectMapper.readValue(msg, ResUnjoinContainer.class);
                        answer = new Response(response, resUnjoinContainer.getData());
                        break;
                    case JOIN_TO_ROOM:
                        ResJoinToRoomContainer resJoinToRoomContainer =
                                this.objectMapper.readValue(msg, ResJoinToRoomContainer.class);
                        answer = new Response(response, resJoinToRoomContainer.getData());
                        break;
                    case USERS_LIST:
                        ResUsersListContainer resUsersListContainer =
                                this.objectMapper.readValue(msg, ResUsersListContainer.class);
                        answer = new Response(response, resUsersListContainer.getData());
                        break;
                    case CHANNEL_COUNTERS:
                        ResChannelCountersContainer resChannelCountersContainer =
                                this.objectMapper.readValue(msg, ResChannelCountersContainer.class);
                        answer = new Response(response, resChannelCountersContainer.getData());
                        break;
                    case LIST:
                        ResModeratorsListContainer resModeratorsListContainer =
                                this.objectMapper.readValue(msg, ResModeratorsListContainer.class);
                        answer = new Response(response, resModeratorsListContainer.getData());
                        break;
                    case MODER_RIGHTS:
                        ResModeratorRightContainer resModeratorRightContainer =
                                this.objectMapper.readValue(msg, ResModeratorRightContainer.class);
                        answer = new Response(response, resModeratorRightContainer.getData());
                        break;
                    case SETTING:
                        ResSettingsContainer resSettingsContainer =
                                this.objectMapper.readValue(msg, ResSettingsContainer.class);
                        answer = new Response(response, resSettingsContainer.getData());
                        break;
                    case IGNORE_LIST:
                        ResIgnoreListContainer resIgnoreListContainer =
                                this.objectMapper.readValue(msg, ResIgnoreListContainer.class);
                        answer = new Response(response, resIgnoreListContainer.getData());
                        break;
                    case CHANNEL_HISTORY:
                        ResChannelHistoryContainer resChannelHistoryContainer =
                                this.objectMapper.readValue(msg, ResChannelHistoryContainer.class);
                        answer = new Response(response, resChannelHistoryContainer.getData());
                        break;
                    case MOTD:
                        ResMotdContainer resMotdContainer =
                                this.objectMapper.readValue(msg, ResMotdContainer.class);
                        answer = new Response(response, resMotdContainer.getData());
                        break;
                    case SLOWMOD:
                        ResSlowmodContainer resSlowmodContainer =
                                this.objectMapper.readValue(msg, ResSlowmodContainer.class);
                        answer = new Response(response, resSlowmodContainer.getData());
                        break;
                    case MESSAGE:
                        ResMessageContainer resMessageContainer =
                                this.objectMapper.readValue(msg, ResMessageContainer.class);
                        answer = new Response(response, resMessageContainer.getData());
                        break;
                    case PRIVATE_MESSAGE:
                        ResPrivateMessageContainer resPrivateMessageContainer =
                                this.objectMapper.readValue(msg, ResPrivateMessageContainer.class);
                        answer = new Response(response, resPrivateMessageContainer.getData());
                        break;
                    case REMOVE_MESSAGE:
                        ResRemoveMessageContainer resRemoveMessageContainer =
                                this.objectMapper.readValue(msg, ResRemoveMessageContainer.class);
                        answer = new Response(response, resRemoveMessageContainer.getData());
                        break;
                    case USER_BAN:
                        ResUserBanContainer resUserBanContainer =
                                this.objectMapper.readValue(msg, ResUserBanContainer.class);
                        answer = new Response(response, resUserBanContainer.getData());
                        break;
                    case USER_WARN:
                        ResWarnContainer resWarnContainer =
                                this.objectMapper.readValue(msg, ResWarnContainer.class);
                        answer = new Response(response, resWarnContainer.getData());
                        break;
                    case NEW_POLL:
                        ResNewPollContainer resNewPollContainer =
                                this.objectMapper.readValue(msg, ResNewPollContainer.class);
                        answer = new Response(response, resNewPollContainer.getData());
                        break;
                    case POLL_RESULTS:
                        ResPollResultsContainer resPollResultsContainer =
                                this.objectMapper.readValue(msg, ResPollResultsContainer.class);
                        answer = new Response(response, resPollResultsContainer.getData());
                        break;
                    case USER:
                        ResGetUserInfoContainer resGetUserInfoContainer =
                                this.objectMapper.readValue(msg, ResGetUserInfoContainer.class);
                        answer = new Response(response, resGetUserInfoContainer.getData());
                        break;
                    case UPDATE_RIGHTS:
                        ResUpdateRightsContainer resUpdateRightsContainer =
                                this.objectMapper.readValue(msg, ResUpdateRightsContainer.class);
                        answer = new Response(response, resUpdateRightsContainer.getData());
                        break;
                    case UPDATE_GROUPS:
                        ResUpdateGroupsContainer resUpdateGroupsContainer =
                                this.objectMapper.readValue(msg, ResUpdateGroupsContainer.class);
                        answer = new Response(response, resUpdateGroupsContainer.getData());
                        break;
                    case UPDATE_PREMIUM:
                        ResUpdatePremiumContainer resUpdatePremiumContainer =
                                this.objectMapper.readValue(msg, ResUpdatePremiumContainer.class);
                        answer = new Response(response, resUpdatePremiumContainer.getData());
                        break;
                    case PAYMENT:
                        ResPaymentContainer resPaymentContainer =
                                this.objectMapper.readValue(msg, ResPaymentContainer.class);
                        answer = new Response(response, resPaymentContainer.getData());
                        break;
                    case PREMIUM:
                        ResPremiumContainer resPremiumContainer =
                                this.objectMapper.readValue(msg, ResPremiumContainer.class);
                        answer = new Response(response, resPremiumContainer.getData());
                        break;
                    case ERROR:
                        ResErrorContainer resErrorContainer =
                                this.objectMapper.readValue(msg, ResErrorContainer.class);
                        answer = new Response(response, resErrorContainer.getData());
                        break;
                    default:
                        answer = new Response(ChatResponses.UNKNOWN, null);
                        System.out.println(msg);
                        break;
                }

                this.chat.onMessage(answer);

            } catch (IOException e) {
                logger.error("On message receive exception: {}", e.getLocalizedMessage());
                e.printStackTrace();
            }
        }

        public final void onMessage(final Response response) {
            this.chat.onMessage(response);
        }


        protected final void sendMessage(final String s) {
            if (this.session != null) {
                try {
                    Future<Void> fut;
                    fut = this.session.getRemote().sendStringByFuture(s);
                    fut.get(2, TimeUnit.SECONDS);

                } catch (Throwable t) {
                    logger.error("send Message exception: {}", t.getLocalizedMessage());
                    t.printStackTrace();
                }
            }
        }

        public final void setChat(final GoodChat chat) {
            this.chat = chat;
        }
    }
}
