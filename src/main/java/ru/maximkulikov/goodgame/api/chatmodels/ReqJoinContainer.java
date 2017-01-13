package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqJoinContainer implements ReqChatObject {
    private String type = "join";
    private ReqJoin data;

    public ReqJoinContainer(String channelId, boolean hidden, boolean mobile) {
        this.data = new ReqJoin(channelId, hidden, mobile);
    }

    public ReqJoin getData() {
        return data;
    }

    public void setData(ReqJoin data) {
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
        return "ReqJoinContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
