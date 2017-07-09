package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRemoveMessage {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("message_id")
    private String messageId;

    /**
     * @param channelId channel_id
     * @param messageId message_id
     */
    public ReqRemoveMessage(final String channelId, final String messageId) {
        this.channelId = channelId;
        this.messageId = messageId;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final void setMessageId(final String messageId) {
        this.messageId = messageId;
    }

    @Override
    public final String toString() {
        return "ReqRemoveMessage{" +
                "channelId='" + this.channelId + '\'' +
                ", messageId='" + this.messageId + '\'' +
                '}';
    }
}
