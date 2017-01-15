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
        return channel;
    }

    public final void setChannel(final String channel) {
        this.channel = channel;
    }

    public final String getChannelId() {
        return channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getSrc() {
        return src;
    }

    public final void setSrc(final String src) {
        this.src = src;
    }

    @Override
    public final String toString() {
        return "InfoChannel{" +
                "channel='" + channel + '\'' +
                ", channelId='" + channelId + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
