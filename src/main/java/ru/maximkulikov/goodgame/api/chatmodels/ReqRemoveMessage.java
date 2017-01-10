package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRemoveMessage {
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("message_id")
    private String messageId;

    public ReqRemoveMessage(String channelId, String messageId) {
        this.channelId = channelId;
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "ReqRemoveMessage{" +
                "channelId='" + channelId + '\'' +
                ", messageId='" + messageId + '\'' +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}