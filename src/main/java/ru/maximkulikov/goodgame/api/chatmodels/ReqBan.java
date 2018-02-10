package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@Data
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
}
