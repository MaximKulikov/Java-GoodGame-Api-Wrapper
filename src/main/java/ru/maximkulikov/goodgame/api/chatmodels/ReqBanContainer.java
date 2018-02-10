package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqBanContainer implements ReqChatObject {

    private String type = "ban";

    private ReqBan data;

    /**
     * @param channelId  channel_id канал в котором вынесен бан
     * @param banChannel ban_channel канал в котором необходимо забанить, если 0 - то на все каналы
     * @param userId     user_id
     * @param duration   duration время бана в секундах
     * @param reason     reason причина бана
     * @param comment    comment текст сообщения, за который вынесен бан
     * @param showBan    show_ban показывать бан
     */
    public ReqBanContainer(final String channelId, final String banChannel, final String userId, final int duration,
                           final String reason, final String comment, final Boolean showBan) {
        this.data = new ReqBan(channelId, banChannel, userId, duration, reason, comment, showBan);
    }

}
