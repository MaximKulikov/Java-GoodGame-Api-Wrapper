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

    public ReqGetPoll getData() {
        return data;
    }

    public void setData(ReqGetPoll data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReqGetPollContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
