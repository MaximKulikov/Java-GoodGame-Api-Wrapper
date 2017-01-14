package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelsListContainer {

    private String type;

    private ResChannelsList data;

    public final ResChannelsList getData() {
        return data;
    }

    public final void setData(final ResChannelsList data) {
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
        return "ResChannelsListContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
