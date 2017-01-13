package ru.maximkulikov.goodgame.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import ru.maximkulikov.goodgame.api.chatmodels.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */

@WebSocket(maxTextMessageSize = 64 * 1024)
public class GoodChatSocket {

    protected static final ObjectMapper objectMapper = new ObjectMapper();
    private final CountDownLatch closeLatch;

    private Session session;
    private GoodChat chat;

    public GoodChatSocket() {
        this.closeLatch = new CountDownLatch(1);
    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

    public void close() {
        session.close(StatusCode.NORMAL, "Session close");
        chat.setConnected(false);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.printf("Connection closed: %d - %s%n", statusCode, reason);
        this.session = null;
        this.closeLatch.countDown(); // trigger latch
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.printf("Got connect: %s%n", session);
        this.session = session;
        chat.setConnected(true);

    }

    @OnWebSocketMessage
    public void onMessage(String msg) {
        Response answer = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String type = mapper.readTree(msg).get("type").asText();
            ChatResponses response = ChatResponses.valueOf(type.toUpperCase());

            switch (response) {

                case WELCOME:
                    ResWelcomeContainer resWelcomeContainer = objectMapper.readValue(msg, ResWelcomeContainer.class);
                    answer = new Response(response, resWelcomeContainer.getData());
                    break;
                case SUCCESS_AUTH:
                    ResAutorizationContainer resAutorizationContainer = objectMapper.readValue(msg, ResAutorizationContainer.class);
                    answer = new Response(response, resAutorizationContainer.getData());
                    break;
                case CHANNELS_LIST:
                    ResChannelsListContainer resChannelsListContainer = objectMapper.readValue(msg, ResChannelsListContainer.class);
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
                    ResJoinToRoomContainer resJoinToRoomContainer = objectMapper.readValue(msg, ResJoinToRoomContainer.class);
                    answer = new Response(response, resJoinToRoomContainer.getData());
                    break;
                case USERS_LIST:
                    ResUsersListContainer resUsersListContainer = objectMapper.readValue(msg, ResUsersListContainer.class);
                    answer = new Response(response, resUsersListContainer.getData());
                    break;
                case CHANNEL_COUNTERS:
                    ResChannelCountersContainer resChannelCountersContainer = objectMapper.readValue(msg, ResChannelCountersContainer.class);
                    answer = new Response(response, resChannelCountersContainer.getData());
                    break;
                case LIST:
                    ResModeratorsListContainer resModeratorsListContainer  = objectMapper.readValue(msg, ResModeratorsListContainer.class);
                    answer = new Response(response, resModeratorsListContainer.getData());
                    break;
                case SETTING: // TODO
                    answer = new Response(ChatResponses.UNKNOWN, null);
                    System.out.println(msg);
                    break;
                case IGNORE_LIST:
                    ResIgnoreListContainer resIgnoreListContainer   = objectMapper.readValue(msg, ResIgnoreListContainer.class);
                    answer = new Response(response, resIgnoreListContainer.getData());
                    break;
                case CHANNEL_HISTORY:
                    ResChannelHistoryContainer resChannelHistoryContainer = objectMapper.readValue(msg, ResChannelHistoryContainer.class);
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
                    ResMessageContainer resMessageContainer  = objectMapper.readValue(msg, ResMessageContainer.class);
                    answer = new Response(response, resMessageContainer.getData());
                    break;
                case PRIVATE_MESSAGE:
                    ResPrivateMessageContainer resPrivateMessageContainer = objectMapper.readValue(msg, ResPrivateMessageContainer.class);
                    answer = new Response(response, resPrivateMessageContainer.getData());
                    break;
                case REMOVE_MESSAGE:
                    ResRemoveMessageContainer resRemoveMessageContainer =objectMapper.readValue(msg, ResRemoveMessageContainer.class);
                    answer = new Response(response, resRemoveMessageContainer.getData());
                    break;
                case USER_BAN:
                    ResUserBanContainer resUserBanContainer = objectMapper.readValue(msg, ResUserBanContainer.class);
                    answer = new Response(response, resUserBanContainer.getData());
                    break;
                case USER_WARN:
                    ResWarnContainer resWarnContainer =objectMapper.readValue(msg, ResWarnContainer.class);
                    answer = new Response(response, resWarnContainer.getData());
                    break;

                case NEW_POLL: //TODO
                    answer = new Response(ChatResponses.UNKNOWN, null);
                    System.out.println(msg);
                case POLL_RESULTS:
                    ResPollResultsContainer resPollResultsContainer = objectMapper.readValue(msg, ResPollResultsContainer.class);
                    answer = new Response(response, resPollResultsContainer.getData());
                    break;
                case USER:
                    ResGetUserInfoContainer resGetUserInfoContainer = objectMapper.readValue(msg, ResGetUserInfoContainer.class);
                    answer = new Response(response, resGetUserInfoContainer.getData());
                    break;
                case UPDATE_RIGHTS:
                    ResUpdateRightsContainer resUpdateRightsContainer = objectMapper.readValue(msg, ResUpdateRightsContainer.class);
                    answer = new Response(response, resUpdateRightsContainer.getData());
                    break;
                case UPDATE_GROUPS: //TODO
                    answer = new Response(ChatResponses.UNKNOWN, null);
                    System.out.println(msg);
                case UPDATE_PREMIUM:
                    ResUpdatePremiumContainer resUpdatePremiumContainer = objectMapper.readValue(msg, ResUpdatePremiumContainer.class);
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
                    ResErrorContainer resErrorContainer=  objectMapper.readValue(msg, ResErrorContainer.class);
                    answer = new Response(response, resErrorContainer.getData());
                    break;
                default:
                    answer = new Response(ChatResponses.UNKNOWN, null);
                    System.out.println(msg);
                    break;
            }
            chat.onMessage(answer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void sendMessage(String s) {
        if (session != null) {
            try {
                Future<Void> fut;
                fut = session.getRemote().sendStringByFuture(s);
                fut.get(2, TimeUnit.SECONDS); // wait for send to complete.

            } catch (Throwable t) {
                t.printStackTrace();
            }
        }

    }

    public void setChat(GoodChat chat) {
        this.chat = chat;
    }
}


