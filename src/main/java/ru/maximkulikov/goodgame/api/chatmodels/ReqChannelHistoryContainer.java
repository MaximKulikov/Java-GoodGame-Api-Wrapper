package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelHistoryContainer implements ReqChatObject {

    private String type = "get_channel_history";

    private ReqChannelHistory data;

    public ReqChannelHistoryContainer(final String channelId) {
        this.data = new ReqChannelHistory(channelId);
    }

    public final ReqChannelHistory getData() {
        return this.data;
    }

    public final void setData(final ReqChannelHistory data) {
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
        return "ReqChannelHistoryContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
