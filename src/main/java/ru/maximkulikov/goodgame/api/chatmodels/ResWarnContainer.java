package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResWarnContainer {

    private String type;

    private ResWarn data;

    public final ResWarn getData() {
        return data;
    }

    public final void setData(final ResWarn data) {
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
        return "ResWarnContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
