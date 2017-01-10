package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqPollResultsContainer  implements ChatObject{
    private String type = "get_poll_results";
    private ReqGetPoll data;

    public ReqPollResultsContainer(String channelId) {
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
        return "ReqPollResultsContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}