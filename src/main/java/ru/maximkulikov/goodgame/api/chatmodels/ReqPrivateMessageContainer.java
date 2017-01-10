package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqPrivateMessageContainer implements ChatObject {
    private String type = "send_private_message";
    private ReqPrivateMessage data;

    public ReqPrivateMessageContainer(String channelId, String userId, String text) {
        this.data = new ReqPrivateMessage(channelId, userId, text);
    }

    public ReqPrivateMessage getData() {
        return data;
    }

    public void setData(ReqPrivateMessage data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReqPrivateMessageContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
