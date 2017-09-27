package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResChannelHistory that = (ResChannelHistory) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(messages, that.messages)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(messages)
                .toHashCode();
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
