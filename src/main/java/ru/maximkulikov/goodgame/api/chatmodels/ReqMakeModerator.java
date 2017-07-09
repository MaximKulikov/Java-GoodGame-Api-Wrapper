package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqMakeModerator {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("user_id")
    private String userId;

    /**
     * @param channelId channel_id
     * @param userId    user_id
     */
    public ReqMakeModerator(final String channelId, final String userId) {
        this.channelId = channelId;
        this.userId = userId;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public final String toString() {
        return "ReqMakeModerator{" +
                "channelId='" + this.channelId + '\'' +
                ", userId='" + this.userId + '\'' +
                '}';
    }
}
