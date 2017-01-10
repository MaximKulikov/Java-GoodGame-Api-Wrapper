package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqUsersList {
    @JsonProperty("channel_id")
    private String channelId;

    public ReqUsersList(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "ReqUsersList{" +
                "channelId='" + channelId + '\'' +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}