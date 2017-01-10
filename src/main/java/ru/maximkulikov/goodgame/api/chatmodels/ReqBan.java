package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqBan {
    @JsonProperty("channel_id")
    private String channelId; // канал в котором вынесен бан
    @JsonProperty("ban_channel")
    private String banChannel; // канал в котором необходимо забанить, если 0 - то на все каналы
    @JsonProperty("user_id")
    private String userId;
    private Long duration; // время бана в секундах
    private String reason; //причина
    private String comment; // текст сообщения, за который вынесен бан
    private Boolean show_ban; // показывать ли бан

    public ReqBan(String channelId, String banChannel, String userId, Long duration, String reason, String comment, Boolean show_ban) {
        this.channelId = channelId;
        this.banChannel = banChannel;
        this.userId = userId;
        this.duration = duration;
        this.reason = reason;
        this.comment = comment;
        this.show_ban = show_ban;
    }

    @Override
    public String toString() {
        return "ReqBan{" +
                "channelId='" + channelId + '\'' +
                ", banChannel='" + banChannel + '\'' +
                ", userId='" + userId + '\'' +
                ", duration=" + duration +
                ", reason='" + reason + '\'' +
                ", comment='" + comment + '\'' +
                ", show_ban=" + show_ban +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getBanChannel() {
        return banChannel;
    }

    public void setBanChannel(String banChannel) {
        this.banChannel = banChannel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getShow_ban() {
        return show_ban;
    }

    public void setShow_ban(Boolean show_ban) {
        this.show_ban = show_ban;
    }
}
