package ru.maximkulikov.goodgame.api;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import ru.maximkulikov.goodgame.api.chatmodels.ReqChatObject;
import ru.maximkulikov.goodgame.api.chatmodels.Response;

/**
 * Java-GoodGame-Api-Wrapper
 */
public abstract class GoodChat {

    protected static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String DEFAULT_CHAT_URL = "ws://chat.goodgame.ru:8081/chat/websocket";
    private GoodChatSocket socket;

    private boolean connected;

    public final void connect() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                WebSocketClient client = new WebSocketClient();
                GoodChat.this.socket = new GoodChatSocket();
                try {
                    client.start();
                    URI echoUri = new URI(DEFAULT_CHAT_URL);
                    ClientUpgradeRequest request = new ClientUpgradeRequest();
                    client.connect(socket, echoUri, request);
                    System.out.printf("Connecting to : %s%n", echoUri);
                    // wait for closed socket connection.
                    GoodChat.this.socket.setChat(GoodChat.this);
                    GoodChat.this.socket.awaitClose(24, TimeUnit.HOURS);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        client.stop();
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
                wait(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (this.socket != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                this.socket.sendMessage(mapper.writeValueAsString(chatObject));
            } catch (JsonProcessingException e) {
//TODO
            }
        } else {
            throw new NullPointerException("GoodGameChat not connected proper");

        }
    }

}
