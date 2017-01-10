package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdateRights {
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("access_rights")
    private Long accessRights;

    public Long getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(Long accessRights) {
        this.accessRights = accessRights;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "ResUpdateRights{" +
                "channelId='" + channelId + '\'' +
                ", accessRights=" + accessRights +
                '}';
    }
}
