package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 20.01.2017
 */
public class ResAccepted implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    @Override
    public final String toString() {
        return "ResAccepted{" +
                "channelId='" + this.channelId + '\'' +
                '}';
    }
}
