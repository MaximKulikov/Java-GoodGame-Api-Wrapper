package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelHistoryContainer  {
    private String type;
    private ResChannelHistory data;

    public ResChannelHistory getData() {
        return data;
    }

    public void setData(ResChannelHistory data) {
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
        return "ResChannelHistoryContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
