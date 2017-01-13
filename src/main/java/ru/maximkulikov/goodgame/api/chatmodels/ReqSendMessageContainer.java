package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqSendMessageContainer  implements ReqChatObject {
    private String type = "send_message";
    private ReqSendMessage data;

    public ReqSendMessageContainer(String channelId, String text, Boolean hideIcon, Boolean mobile) {
        this.data = new ReqSendMessage(channelId, text, hideIcon, mobile);
    }

    public ReqSendMessageContainer(String channelId, String text) {
        this.data = new ReqSendMessage(channelId, text);
    }

    public ReqSendMessage getData() {
        return data;
    }

    public void setData(ReqSendMessage data) {
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
        return "ReqSendMessageContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
