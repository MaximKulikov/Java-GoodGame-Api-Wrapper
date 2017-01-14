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
public class GoodChat {
    public static final String DEFAULT_CHAT_URL = "ws://chat.goodgame.ru:8081/chat/websocket";
    protected static final ObjectMapper objectMapper = new ObjectMapper();
    private GoodChatSocket socket = null;
    private boolean connected = false;

    public void connect() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                WebSocketClient client = new WebSocketClient();
                socket = new GoodChatSocket();
                try {
                    client.start();
                    URI echoUri = new URI(DEFAULT_CHAT_URL);
                    ClientUpgradeRequest request = new ClientUpgradeRequest();
                    client.connect(socket, echoUri, request);
                    System.out.printf("Connecting to : %s%n", echoUri);
                    // wait for closed socket connection.
                    socket.setChat(GoodChat.this);
                    socket.awaitClose(24, TimeUnit.HOURS);

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

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void onMessage(Response answer) {
//Переопредели меня :D
    }

    public void sendMessage(ReqChatObject chatObject) {
        if (socket != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                socket.sendMessage(mapper.writeValueAsString(chatObject));
            } catch (JsonProcessingException e) {

            }
        } else {
            try {
                Thread.sleep(777);
                sendMessage(chatObject);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //throw new NullPointerException("GoodGameChat not connected proper");

        }
    }

}
