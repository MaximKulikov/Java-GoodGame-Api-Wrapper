package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqGetPoll {

    @JsonProperty("channel_id")
    private String channelId;

    /**
     * @param channelId channel_id
     */
    public ReqGetPoll(final String channelId) {
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
        return "ReqGetPoll{" +
                "channelId='" + this.channelId + '\'' +
                '}';
    }
}
