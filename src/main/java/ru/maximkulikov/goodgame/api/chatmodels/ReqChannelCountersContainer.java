package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelCountersContainer implements ReqChatObject {
    private String type = "get_channel_counters";
    private ReqChannelCounters data;

    public ReqChannelCountersContainer(String channelId) {
        this.data = new ReqChannelCounters(channelId);
    }

    public ReqChannelCounters getData() {
        return data;
    }

    public void setData(ReqChannelCounters data) {
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
        return "ReqChannelCountersContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
