package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoChannel {

    private String channel;

    @JsonProperty("channel_id")
    private String channelId;

    private String src;

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(final String channel) {
        this.channel = channel;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getSrc() {
        return this.src;
    }

    public final void setSrc(final String src) {
        this.src = src;
    }

    @Override
    public final String toString() {
        return "InfoChannel{" +
                "channel='" + this.channel + '\'' +
                ", channelId='" + this.channelId + '\'' +
                ", src='" + this.src + '\'' +
                '}';
    }
}
