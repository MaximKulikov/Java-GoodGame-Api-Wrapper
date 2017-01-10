package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqUnjoinContainer implements ChatObject{
    private String type = "unjoin";
    private ReqUnjoin data;

    public ReqUnjoinContainer(String channelId) {
        this.data = new ReqUnjoin(channelId);
    }

    public ReqUnjoin getData() {
        return data;
    }

    public void setData(ReqUnjoin data) {
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
        return "ReqUnjoinContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
