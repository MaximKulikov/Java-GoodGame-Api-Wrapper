package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResIgnoreListContainer {

    private String type;

    private ResIgnoreList data;

    public final ResIgnoreList getData() {
        return data;
    }

    public final void setData(final ResIgnoreList data) {
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
        return "ResIgnoreListContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
