package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUnjoinContainer {

    private String type;

    private ResUnjoin data;

    public final ResUnjoin getData() {
        return data;
    }

    public final void setData(final ResUnjoin data) {
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
        return "ResUnjoinContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
