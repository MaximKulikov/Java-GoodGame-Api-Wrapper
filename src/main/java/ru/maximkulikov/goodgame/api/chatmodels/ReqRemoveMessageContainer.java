package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRemoveMessageContainer  implements ChatObject{
    private String type = "remove_message";
    private ReqRemoveMessage data;

    public ReqRemoveMessageContainer(String channelId, String messageId) {
        this.data = new ReqRemoveMessage(channelId, messageId);
    }

    public ReqRemoveMessage getData() {
        return data;
    }

    public void setData(ReqRemoveMessage data) {
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
        return "ReqRemoveMessageContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
