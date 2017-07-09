package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqGetPollContainer implements ReqChatObject {

    private String type = "get_poll";

    private ReqGetPoll data;

    /**
     * @param channelId channel_id
     */
    public ReqGetPollContainer(final String channelId) {
        this.data = new ReqGetPoll(channelId);
    }

    public final ReqGetPoll getData() {
        return this.data;
    }

    public final void setData(final ReqGetPoll data) {
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
        return "ReqGetPollContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
