package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelCountersContainer implements ChatObject {
    private String type;
    private ResChannelCounters data;

    public ResChannelCounters getData() {
        return data;
    }

    public void setData(ResChannelCounters data) {
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
        return "ResChannelCountersContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
