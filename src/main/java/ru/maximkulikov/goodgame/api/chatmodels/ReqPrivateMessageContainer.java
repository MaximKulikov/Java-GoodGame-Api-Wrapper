package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqPrivateMessageContainer implements ReqChatObject {

    private String type = "send_private_message";

    private ReqPrivateMessage data;

    public ReqPrivateMessageContainer(String channelId, String userId, String text) {
        this.data = new ReqPrivateMessage(channelId, userId, text);
    }

    public final ReqPrivateMessage getData() {
        return this.data;
    }

    public final void setData(final ReqPrivateMessage data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqPrivateMessageContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
