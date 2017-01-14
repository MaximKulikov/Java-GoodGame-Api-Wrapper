package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqPrivateMessage {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("user_id")
    private String userId;

    private String text;

    public ReqPrivateMessage(String channelId, String userId, String text) {
        this.channelId = channelId;
        this.userId = userId;
        this.text = text;
    }

    public final String getChannelId() {
        return channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getText() {
        return text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    public final String getUserId() {
        return userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public final String toString() {
        return "ReqPrivateMessage{" +
                "channelId='" + channelId + '\'' +
                ", userId='" + userId + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
