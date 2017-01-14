package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelCountersContainer {

    private String type;

    private ResChannelCounters data;

    public final ResChannelCounters getData() {
        return data;
    }

    public final void setData(final ResChannelCounters data) {
        this.data = data;
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ResChannelCountersContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
