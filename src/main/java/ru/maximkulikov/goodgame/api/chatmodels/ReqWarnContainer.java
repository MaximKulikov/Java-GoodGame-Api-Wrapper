package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqWarnContainer implements ReqChatObject {

    private String type = "warn";

    private ReqWarn data;

    public ReqWarnContainer(final String channelId, final String userId, final String reason) {
        this.data = new ReqWarn(channelId, userId, reason);
    }

    public final ReqWarn getData() {
        return this.data;
    }

    public final void setData(final ReqWarn data) {
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
        return "ReqWarnContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
