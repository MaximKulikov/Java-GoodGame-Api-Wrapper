package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResJoinToRoomContainer implements ChatObject {
    private String type;
    private ResJoinToRoom data;

    public ResJoinToRoom getData() {
        return data;
    }

    public void setData(ResJoinToRoom data) {
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
        return "ResJoinToRoomContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
