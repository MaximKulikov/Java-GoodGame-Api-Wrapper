package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 14.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResSettingsContainer {

    private String type;

    private ResSettings data;

    public final ResSettings getData() {
        return this.data;
    }

    public final void setData(final ResSettings data) {
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
        return "ResSettingsContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
