package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqGetPollContainer implements ReqChatObject {

    private String type = "get_poll";

    private ReqGetPoll data;

    public ReqGetPollContainer(String channelId) {
        this.data = new ReqGetPoll(channelId);
    }

    public final ReqGetPoll getData() {
        return data;
    }

    public final void setData(final ReqGetPoll data) {
        this.data = data;
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqGetPollContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
