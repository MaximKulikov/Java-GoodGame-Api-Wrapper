package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 20.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResAcceptedContainer {

    private String type;

    private ResAccepted data;

    public ResAccepted getData() {
        return this.data;
    }

    public final void setData(final ResAccepted data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ResAcceptedContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
