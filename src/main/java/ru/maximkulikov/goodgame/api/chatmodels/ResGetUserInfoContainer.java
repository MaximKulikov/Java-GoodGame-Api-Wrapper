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

    public final ChatUser getData() {
        return data;
    }

    public void setData(final ChatUser data) {
        this.data = data;
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
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