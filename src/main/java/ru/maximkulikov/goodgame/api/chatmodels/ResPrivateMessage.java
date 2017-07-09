package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResPrivateMessage implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("target_id")
    private String targetId;

    @JsonProperty("target_name")
    private String targetName;

    private String timestamp;

    private String text;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public final void setTargetId(final String targetId) {
        this.targetId = targetId;
    }

    public final String getTargetName() {
        return this.targetName;
    }

    public final void setTargetName(final String targetName) {
        this.targetName = targetName;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public final String toString() {
        return "ResPrivateMessage{" +
                "channelId='" + this.channelId + '\'' +
                ", userId='" + this.userId + '\'' +
                ", userName='" + this.userName + '\'' +
                ", targetId='" + this.targetId + '\'' +
                ", targetName='" + this.targetName + '\'' +
                ", timestamp='" + this.timestamp + '\'' +
                ", text='" + this.text + '\'' +
                '}';
    }
}
