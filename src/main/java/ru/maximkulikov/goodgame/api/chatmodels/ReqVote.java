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

    public final int getAnswerId() {
        return answerId;
    }

    public final void setAnswerId(final int answerId) {
        this.answerId = answerId;
    }

    public final String getChannelId() {
        return channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    @Override
    public final String toString() {
        return "ReqVote{" +
                "channelId='" + channelId + '\'' +
                ", answerId=" + answerId +
                '}';
    }
}
