package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUserBan implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("moder_id")
    private String moderId;

    @JsonProperty("moder_name")
    private String moderName;

    @JsonProperty("moder_group")
    private Long moderGroup;

    private Long duration;

    private String reason;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final void setDuration(final Long duration) {
        this.duration = duration;
    }

    public final Long getModerGroup() {
        return this.moderGroup;
    }

    public final void setModerGroup(final Long moderGroup) {
        this.moderGroup = moderGroup;
    }

    public final String getModerId() {
        return this.moderId;
    }

    public final void setModerId(final String moderId) {
        this.moderId = moderId;
    }

    public final String getModerName() {
        return this.moderName;
    }

    public final void setModerName(final String moderName) {
        this.moderName = moderName;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setReason(final String reason) {
        this.reason = reason;
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
        return "ResUserBanContainer{" +
                "channelId='" + this.channelId + '\'' +
                ", userId='" + this.userId + '\'' +
                ", userName='" + this.userName + '\'' +
                ", moderId='" + this.moderId + '\'' +
                ", moderName='" + this.moderName + '\'' +
                ", moderGroup=" + this.moderGroup +
                ", duration=" + this.duration +
                ", reason='" + this.reason + '\'' +
                '}';
    }
}


