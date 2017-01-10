package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelHistoryContainer implements ChatObject {
    private String type = "get_channel_history";
    private ReqChannelHistory data;

    public ReqChannelHistoryContainer(String channelId) {
        this.data = new ReqChannelHistory(channelId);
    }

    public ReqChannelHistory getData() {
        return data;
    }

    public void setData(ReqChannelHistory data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReqChannelHistoryContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
