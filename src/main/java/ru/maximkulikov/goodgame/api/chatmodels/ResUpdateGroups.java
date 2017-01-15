package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 14.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdateGroups implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private List<String> groups;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final void setGroups(final List<String> groups) {
        this.groups = groups;
    }

    @Override
    public final String toString() {
        return "ResUpdateGroups{" +
                "channelId='" + this.channelId + '\'' +
                ", groups=" + this.groups +
                '}';
    }
}
