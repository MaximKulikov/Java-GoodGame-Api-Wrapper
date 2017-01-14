package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqBan {
    // канал в котором вынесен бан
    @JsonProperty("channel_id")
    private String channelId;

    // канал в котором необходимо забанить, если 0 - то на все каналы
    @JsonProperty("ban_channel")
    private String banChannel;

    @JsonProperty("user_id")
    private String userId;

    // время бана в секундах
    private Long duration;

    //причина
    private String reason;

    // текст сообщения, за который вынесен бан
    private String comment;

    // показывать ли бан
    @JsonProperty("show_ban")
    private Boolean showBan;

    public ReqBan(final String channelId,  final String banChannel, final  String userId,  final Long duration,
                  final  String reason,  final String comment,
                  Boolean showBan) {
        this.channelId = channelId;
        this.banChannel = banChannel;
        this.userId = userId;
        this.duration = duration;
        this.reason = reason;
        this.comment = comment;
        this.showBan = showBan;
    }

    public final String getBanChannel() {
        return this.banChannel;
    }

    public void setBanChannel(final String banChannel) {
        this.banChannel = banChannel;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getComment() {
        return this.comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public void setDuration(final Long duration) {
        this.duration = duration;
    }

    public final String getReason() {
        return this.reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

    public final Boolean getShowBan() {
        return this.showBan;
    }

    public void setShowBan(final Boolean show_ban) {
        this.showBan = showBan;
    }

    public final String getUserId() {
        return this.userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ReqBan{" +
                "channelId='" + this.channelId + '\'' +
                ", banChannel='" + this.banChannel + '\'' +
                ", userId='" + this.userId + '\'' +
                ", duration=" + this.duration +
                ", reason='" + this.reason + '\'' +
                ", comment='" + this.comment + '\'' +
                ", showBan=" + this.showBan +
                '}';
    }
}
