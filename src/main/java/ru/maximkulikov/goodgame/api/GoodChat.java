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
import ru.maximkulikov.goodgame.api.chatmodels.*;

/**
 * Java-GoodGame-Api-Wrapper
 */
public abstract class GoodChat {

    protected static final ObjectMapper objectMapper = new ObjectMapper();

    private static final String DEFAULT_CHAT_URL = "ws://chat.goodgame.ru:8081/chat/websocket";

    private GoodChatSocket socket;

    private WebSocketClient client;

    private boolean connected;

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
                    System.out.printf("Connecting to : %s%n", echoUri);
                    // wait for closed socket connection.
                    GoodChat.this.socket.setChat(GoodChat.this);
                    GoodChat.this.socket.awaitClose(24, TimeUnit.HOURS);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        GoodChat.this.client.stop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public final boolean isConnected() {
        return this.connected;
    }

    public final void setConnected(final boolean connected) {
        this.connected = connected;
    }

    public abstract void onMessage(final Response answer);

    public final void sendMessage(final ReqChatObject chatObject) {

        if (this.socket == null) {
            try {
                Thread.sleep(700);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (this.socket != null) {

            ObjectMapper mapper = new ObjectMapper();

            try {
                this.socket.sendMessage(mapper.writeValueAsString(chatObject));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {

            ResError error = new ResError();

            error.setErrorNum(0);
            error.setErrorMsg("GoodGameChat not connected proper, Message did not send");
            this.onMessage(new Response(ChatResponses.ERROR, error));
        }
    }

    public final void stop() {
        if (this.connected) {
            try {
                GoodChat.this.client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

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
            System.out.printf("Connection closed: %d - %s%n", statusCode, reason);
            this.session = null;
            // trigger latch
            this.closeLatch.countDown();
        }

        @OnWebSocketConnect
        public final void onConnect(final Session session) {
            System.out.printf("Got connect: %s%n", session);
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
                        ResAcceptedContainer resAcceptedContainer = objectMapper.readValue(msg, ResAcceptedContainer.class);
                        answer = new Response(response, resAcceptedContainer.getData());
                        break;
                    case WELCOME:
                        ResWelcomeContainer resWelcomeContainer = objectMapper.readValue(msg, ResWelcomeContainer.class);
                        answer = new Response(response, resWelcomeContainer.getData());
                        break;
                    case SUCCESS_AUTH:
                        ResAutorizationContainer resAutorizationContainer =
                                objectMapper.readValue(msg, ResAutorizationContainer.class);
                        answer = new Response(response, resAutorizationContainer.getData());
                        break;
                    case CHANNELS_LIST:
                        ResChannelsListContainer resChannelsListContainer =
                                objectMapper.readValue(msg, ResChannelsListContainer.class);
                        answer = new Response(response, resChannelsListContainer.getData());
                        break;
                    case SUCCESS_JOIN:
                        ResJoinContainer resJoinContainer = objectMapper.readValue(msg, ResJoinContainer.class);
                        answer = new Response(response, resJoinContainer.getData());
                        break;
                    case SUCCESS_UNJOIN:
                        ResUnjoinContainer resUnjoinContainer = objectMapper.readValue(msg, ResUnjoinContainer.class);
                        answer = new Response(response, resUnjoinContainer.getData());
                        break;
                    case JOIN_TO_ROOM:
                        ResJoinToRoomContainer resJoinToRoomContainer =
                                objectMapper.readValue(msg, ResJoinToRoomContainer.class);
                        answer = new Response(response, resJoinToRoomContainer.getData());
                        break;
                    case USERS_LIST:
                        ResUsersListContainer resUsersListContainer =
                                objectMapper.readValue(msg, ResUsersListContainer.class);
                        answer = new Response(response, resUsersListContainer.getData());
                        break;
                    case CHANNEL_COUNTERS:
                        ResChannelCountersContainer resChannelCountersContainer =
                                objectMapper.readValue(msg, ResChannelCountersContainer.class);
                        answer = new Response(response, resChannelCountersContainer.getData());
                        break;
                    case LIST:
                        ResModeratorsListContainer resModeratorsListContainer =
                                objectMapper.readValue(msg, ResModeratorsListContainer.class);
                        answer = new Response(response, resModeratorsListContainer.getData());
                        break;
                    case MODER_RIGHTS:
                        ResModeratorRightContainer resModeratorRightContainer =
                                objectMapper.readValue(msg, ResModeratorRightContainer.class);
                        answer = new Response(response, resModeratorRightContainer.getData());
                        break;
                    case SETTING:
                        ResSettingsContainer resSettingsContainer =
                                objectMapper.readValue(msg, ResSettingsContainer.class);
                        answer = new Response(response, resSettingsContainer.getData());
                        break;
                    case IGNORE_LIST:
                        ResIgnoreListContainer resIgnoreListContainer =
                                objectMapper.readValue(msg, ResIgnoreListContainer.class);
                        answer = new Response(response, resIgnoreListContainer.getData());
                        break;
                    case CHANNEL_HISTORY:
                        ResChannelHistoryContainer resChannelHistoryContainer =
                                objectMapper.readValue(msg, ResChannelHistoryContainer.class);
                        answer = new Response(response, resChannelHistoryContainer.getData());
                        break;
                    case MOTD:
                        ResMotdContainer resMotdContainer = objectMapper.readValue(msg, ResMotdContainer.class);
                        answer = new Response(response, resMotdContainer.getData());
                        break;
                    case SLOWMOD:
                        ResSlowmodContainer resSlowmodContainer = objectMapper.readValue(msg, ResSlowmodContainer.class);
                        answer = new Response(response, resSlowmodContainer.getData());
                        break;
                    case MESSAGE:
                        ResMessageContainer resMessageContainer = objectMapper.readValue(msg, ResMessageContainer.class);
                        answer = new Response(response, resMessageContainer.getData());
                        break;
                    case PRIVATE_MESSAGE:
                        ResPrivateMessageContainer resPrivateMessageContainer =
                                objectMapper.readValue(msg, ResPrivateMessageContainer.class);
                        answer = new Response(response, resPrivateMessageContainer.getData());
                        break;
                    case REMOVE_MESSAGE:
                        ResRemoveMessageContainer resRemoveMessageContainer =
                                objectMapper.readValue(msg, ResRemoveMessageContainer.class);
                        answer = new Response(response, resRemoveMessageContainer.getData());
                        break;
                    case USER_BAN:
                        ResUserBanContainer resUserBanContainer = objectMapper.readValue(msg, ResUserBanContainer.class);
                        answer = new Response(response, resUserBanContainer.getData());
                        break;
                    case USER_WARN:
                        ResWarnContainer resWarnContainer = objectMapper.readValue(msg, ResWarnContainer.class);
                        answer = new Response(response, resWarnContainer.getData());
                        break;
                    case NEW_POLL:
                        ResNewPollContainer resNewPollContainer = objectMapper.readValue(msg, ResNewPollContainer.class);
                        answer = new Response(response, resNewPollContainer.getData());
                        break;
                    case POLL_RESULTS:
                        ResPollResultsContainer resPollResultsContainer =
                                objectMapper.readValue(msg, ResPollResultsContainer.class);
                        answer = new Response(response, resPollResultsContainer.getData());
                        break;
                    case USER:
                        ResGetUserInfoContainer resGetUserInfoContainer =
                                objectMapper.readValue(msg, ResGetUserInfoContainer.class);
                        answer = new Response(response, resGetUserInfoContainer.getData());
                        break;
                    case UPDATE_RIGHTS:
                        ResUpdateRightsContainer resUpdateRightsContainer =
                                objectMapper.readValue(msg, ResUpdateRightsContainer.class);
                        answer = new Response(response, resUpdateRightsContainer.getData());
                        break;
                    case UPDATE_GROUPS:
                        ResUpdateGroupsContainer resUpdateGroupsContainer =
                                objectMapper.readValue(msg, ResUpdateGroupsContainer.class);
                        answer = new Response(response, resUpdateGroupsContainer.getData());
                        break;
                    case UPDATE_PREMIUM:
                        ResUpdatePremiumContainer resUpdatePremiumContainer =
                                objectMapper.readValue(msg, ResUpdatePremiumContainer.class);
                        answer = new Response(response, resUpdatePremiumContainer.getData());
                        break;
                    case PAYMENT:
                        ResPaymentContainer resPaymentContainer = objectMapper.readValue(msg, ResPaymentContainer.class);
                        answer = new Response(response, resPaymentContainer.getData());
                        break;
                    case PREMIUM:
                        ResPremiumContainer resPremiumContainer = objectMapper.readValue(msg, ResPremiumContainer.class);
                        answer = new Response(response, resPremiumContainer.getData());
                        break;
                    case ERROR:
                        ResErrorContainer resErrorContainer = objectMapper.readValue(msg, ResErrorContainer.class);
                        answer = new Response(response, resErrorContainer.getData());
                        break;
                    default:
                        answer = new Response(ChatResponses.UNKNOWN, null);
                        System.out.println(msg);
                        break;
                }
                if (answer == null) {
                    System.out.println();
                }
                this.chat.onMessage(answer);


            } catch (IOException e) {
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
                    // wait for send to complete.
                    fut.get(2, TimeUnit.SECONDS);

                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }

        }

        public final void setChat(final GoodChat chat) {
            this.chat = chat;
        }
    }
}
