package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqBanContainer implements ReqChatObject {

    private String type = "ban";

    private ReqBan data;

    public ReqBanContainer(final String channelId, final String banChannel, final String userId, final Long duration,
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
