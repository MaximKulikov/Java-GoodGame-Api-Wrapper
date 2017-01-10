package ru.maximkulikov.goodgame.api;


import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@WebSocket(maxTextMessageSize = 64 * 1024)
public class GoodChatSocket {


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
        System.out.printf("Got msg: %s%n", msg);
    }


    void sendMessage(String s) {
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


