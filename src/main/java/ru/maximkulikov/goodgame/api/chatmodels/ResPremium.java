package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResPremium implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private String userName;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public final String toString() {
        return "ResPremium{" +
                "channelId='" + this.channelId + '\'' +
                ", userName='" + this.userName + '\'' +
                '}';
    }
}

