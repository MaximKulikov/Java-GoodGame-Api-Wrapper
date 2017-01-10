package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqVoteContainer  implements ChatObject{
    private String type = "vote";
    private ReqVote data;


    public ReqVoteContainer(String channelId, int answerId) {
        this.data = new ReqVote(channelId, answerId);
    }

    public ReqVote getData() {
        return data;
    }

    public void setData(ReqVote data) {
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
        return "ReqVoteContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}