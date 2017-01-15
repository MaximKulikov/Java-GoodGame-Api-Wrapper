package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResMessageContainer {

    private String type;

    private ResMessage data;

    public final ResMessage getData() {
        return data;
    }

    public final void setData(final ResMessage data) {
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
        return "ResMessageContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
