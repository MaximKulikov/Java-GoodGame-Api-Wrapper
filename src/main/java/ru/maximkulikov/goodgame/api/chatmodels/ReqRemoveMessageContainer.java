package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRemoveMessageContainer implements ReqChatObject {

    private String type = "remove_message";

    private ReqRemoveMessage data;

    /**
     * @param channelId channel_id
     * @param messageId message_id
     */
    public ReqRemoveMessageContainer(final String channelId, final String messageId) {
        this.data = new ReqRemoveMessage(channelId, messageId);
    }

    public final ReqRemoveMessage getData() {
        return this.data;
    }

    public final void setData(final ReqRemoveMessage data) {
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
        return "ReqRemoveMessageContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
