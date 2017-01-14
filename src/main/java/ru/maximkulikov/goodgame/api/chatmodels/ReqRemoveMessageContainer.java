package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRemoveMessageContainer implements ReqChatObject {

    private String type = "remove_message";

    private ReqRemoveMessage data;

    public ReqRemoveMessageContainer(String channelId, String messageId) {
        this.data = new ReqRemoveMessage(channelId, messageId);
    }

    public final ReqRemoveMessage getData() {
        return data;
    }

    public final void setData(final ReqRemoveMessage data) {
        this.data = data;
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqRemoveMessageContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
