package ru.maximkulikov.goodgame.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import ru.maximkulikov.goodgame.api.chatmodels.ChatObject;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * Java-GoodGame-Api-Wrapper
 */
public class GoodChat {
    public static final String DEFAULT_CHAT_URL = "ws://chat.goodgame.ru:8081/chat/websocket";
    GoodChatSocket socket = null;

    public boolean isConnected() {
        return connected;
    }

     void setConnected(boolean connected) {
        this.connected = connected;
    }

    boolean connected = false;

    public void connect() {
        WebSocketClient client = new WebSocketClient();
        socket = new GoodChatSocket();
        try {
            client.start();
            URI echoUri = new URI(DEFAULT_CHAT_URL);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(socket, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);
            // wait for closed socket connection.
            socket.setChat(this);
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

    public void sendMessage(ChatObject chatObject) {
        if (socket != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                socket.sendMessage(mapper.writeValueAsString(chatObject));
            } catch (JsonProcessingException e) {

            }
        } else {
            throw new NullPointerException("GoodGameChat not connected proper");
        }
    }

}
