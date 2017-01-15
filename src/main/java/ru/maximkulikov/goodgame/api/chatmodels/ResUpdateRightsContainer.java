package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdateRightsContainer {

    private String type;

    private ResUpdateRights data;

    public final ResUpdateRights getData() {
        return data;
    }

    public final void setData(final ResUpdateRights data) {
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
        return "ResUpdateRightsContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}