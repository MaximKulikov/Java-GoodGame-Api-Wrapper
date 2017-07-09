package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 13.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUserBanContainer {

    private String type;

    private ResUserBan data;

    public final ResUserBan getData() {
        return this.data;
    }

    public final void setData(final ResUserBan data) {
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
        return "ResUserBanContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
