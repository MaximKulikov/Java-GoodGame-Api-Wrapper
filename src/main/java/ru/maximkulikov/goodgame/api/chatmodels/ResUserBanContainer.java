package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 13.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUserBanContainer {

    private String type;

    private ResUserBan data;

    public final ResUserBan getData() {
        return data;
    }

    public final void setData(final ResUserBan data) {
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
        return "ResUserBanContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
