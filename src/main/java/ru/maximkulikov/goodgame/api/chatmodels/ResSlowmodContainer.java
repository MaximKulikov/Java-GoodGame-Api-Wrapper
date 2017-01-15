package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResSlowmodContainer {

    private String type;

    private ResSlowmod data;

    public final ResSlowmod getData() {
        return data;
    }

    public final void setData(final ResSlowmod data) {
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
        return "ResSlowmodContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
