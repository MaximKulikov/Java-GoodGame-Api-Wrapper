package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelHistory implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private List<ChatMessage> messages;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final List<ChatMessage> getMessages() {
        return this.messages;
    }

    public final void setMessages(final List<ChatMessage> messages) {
        this.messages = messages;
    }

    @Override
    public final String toString() {
        return "ResChannelHistory{" +
                "channelId='" + this.channelId + '\'' +
                ", messages=" + this.messages +
                '}';
    }
}
