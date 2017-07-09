package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqBan {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("ban_channel")
    private String banChannel;

    @JsonProperty("user_id")
    private String userId;

    private int duration;

    private String reason;

    private String comment;

    @JsonProperty("show_ban")
    private Boolean showBan;

    /**
     * @param channelId  channel_id канал в котором вынесен бан
     * @param banChannel ban_channel канал в котором необходимо забанить, если 0 - то на все каналы
     * @param userId     user_id
     * @param duration   duration время бана в секундах
     * @param reason     reason причина бана
     * @param comment    comment текст сообщения, за который вынесен бан
     * @param showBan    show_ban показывать бан
     */
    public ReqBan(final String channelId, final String banChannel, final String userId, final int duration,
                  final String reason, final String comment, final Boolean showBan) {
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

    public final void setBanChannel(final String banChannel) {
        this.banChannel = banChannel;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(final String comment) {
        this.comment = comment;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final void setDuration(final int duration) {
        this.duration = duration;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setReason(final String reason) {
        this.reason = reason;
    }

    public final Boolean getShowBan() {
        return this.showBan;
    }

    public final void setShowBan(final Boolean showBan) {
        this.showBan = showBan;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public final String toString() {
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
