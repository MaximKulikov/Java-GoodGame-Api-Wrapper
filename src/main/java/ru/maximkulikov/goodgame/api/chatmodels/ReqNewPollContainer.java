package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqNewPollContainer implements ChatObject {
    private String type = "new_poll";
    private ReqNewPoll data;

    public ReqNewPollContainer(String channelId, String moderId, String moderName, String title, List<String> answers) {
        this.data = new ReqNewPoll(channelId, moderId, moderName, title, answers);
    }

    public ReqNewPoll getData() {
        return data;
    }

    public void setData(ReqNewPoll data) {
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
        return "ReqNewPollContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
