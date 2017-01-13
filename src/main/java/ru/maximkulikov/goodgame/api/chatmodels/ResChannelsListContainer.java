package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelsListContainer   {
    private String type;
    private ResChannelsList data;

    @Override
    public String toString() {
        return "ResChannelsListContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResChannelsList getData() {
        return data;
    }

    public void setData(ResChannelsList data) {
        this.data = data;
    }
}
