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

    public ReqWarnContainer(String channelId, String userId, String reason) {
        this.data = new ReqWarn(channelId, userId, reason);
    }

    public final ReqWarn getData() {
        return data;
    }

    public final void setData(final ReqWarn data) {
        this.data = data;
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqWarnContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
