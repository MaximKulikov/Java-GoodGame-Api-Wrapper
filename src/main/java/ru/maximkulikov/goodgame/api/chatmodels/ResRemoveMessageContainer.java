package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResRemoveMessageContainer {
    private String type;
    private ResRemoveMessage data;

    public ResRemoveMessage getData() {
        return data;
    }

    public void setData(ResRemoveMessage data) {
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
        return "ResRemoveMessageContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
