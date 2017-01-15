package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResMotdContainer {

    private String type;

    private ResMotd data;

    public final ResMotd getData() {
        return data;
    }

    public final void setData(final ResMotd data) {
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
        return "ResMotdContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
