package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqVote {
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("answer_id")
    private int answerId;

    public ReqVote(String channelId, int answerId) {
        this.channelId = channelId;
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "ReqVote{" +
                "channelId='" + channelId + '\'' +
                ", answerId=" + answerId +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
