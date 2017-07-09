package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelCounters implements ReqChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    /**
     *
     * @param channelId channel_id
     */
    public ReqChannelCounters(final String channelId) {
        this.channelId = channelId;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    @Override
    public final String toString() {
        return "ReqChannelCounters{" +
                "channelId='" + this.channelId + '\'' +
                '}';
    }
}
