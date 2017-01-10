package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResGetUserInfoContainer {
    private String type;
    private ChatUser data;

    public ChatUser getData() {
        return data;
    }

    public void setData(ChatUser data) {
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
        return "ResGetUserInfoContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}