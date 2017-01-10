package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelHistory
{
    @JsonProperty("channel_id")
    private String channelId;

    public String getChannelId() {
        return channelId;
    }

    public ReqChannelHistory(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "ReqChannelHistory{" +
                "channelId='" + channelId + '\'' +
                '}';
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
