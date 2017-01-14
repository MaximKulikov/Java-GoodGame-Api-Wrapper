package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelHistory implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private List<ChatMessage> messages;

    public final String getChannelId() {
        return channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final List<ChatMessage> getMessages() {
        return messages;
    }

    public final void setMessages(final List<ChatMessage> messages) {
        this.messages = messages;
    }

    @Override
    public final String toString() {
        return "ResChannelHistory{" +
                "channelId='" + channelId + '\'' +
                ", messages=" + messages +
                '}';
    }
}
