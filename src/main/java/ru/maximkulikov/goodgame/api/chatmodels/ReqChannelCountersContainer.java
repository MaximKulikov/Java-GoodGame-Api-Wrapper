package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelCountersContainer implements ReqChatObject {

    private String type = "get_channel_counters";

    private ReqChannelCounters data;

    /**
     * @param channelId channel_id
     */
    public ReqChannelCountersContainer(final String channelId) {
        this.data = new ReqChannelCounters(channelId);
    }

    public final ReqChannelCounters getData() {
        return this.data;
    }

    public final void setData(final ReqChannelCounters data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqChannelCountersContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
