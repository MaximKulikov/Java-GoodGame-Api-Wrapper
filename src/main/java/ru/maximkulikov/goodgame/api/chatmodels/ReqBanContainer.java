package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
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

    public final ReqBan getData() {
        return this.data;
    }

    public final void setData(final ReqBan data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqBanContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
