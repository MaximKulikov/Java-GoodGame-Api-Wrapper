package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 12.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResWelcomeContainer {

    private String type;

    private ResWelcome data;

    public final ResWelcome getData() {
        return data;
    }

    public final void setData(final ResWelcome data) {
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
        return "ResWelcomeContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
