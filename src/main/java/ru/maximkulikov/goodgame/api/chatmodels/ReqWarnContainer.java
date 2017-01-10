package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqWarnContainer  implements ChatObject{
    private String type = "warn";
    private ReqWarn data;

    public ReqWarnContainer(String channelId, String userId, String reason) {
        this.data = new ReqWarn(channelId, userId, reason);
    }

    public ReqWarn getData() {
        return data;
    }

    public void setData(ReqWarn data) {
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
        return "ReqWarnContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
