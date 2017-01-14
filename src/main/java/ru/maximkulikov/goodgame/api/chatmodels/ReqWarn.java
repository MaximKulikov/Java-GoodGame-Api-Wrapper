package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqWarn {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("user_id")
    private String userId;

    private String reason;

    public ReqWarn(String channelId, String userId, String reason) {
        this.channelId = channelId;
        this.userId = userId;
        this.reason = reason;
    }

    public final String getChannelId() {
        return channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getReason() {
        return reason;
    }

    public final void setReason(final String reason) {
        this.reason = reason;
    }

    public final String getUserId() {
        return userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public final String toString() {
        return "ReqWarn{" +
                "channelId='" + channelId + '\'' +
                ", userId='" + userId + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
