package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 12.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResWelcomeContainer {

    private String type;

    private ResWelcome data;

    public final ResWelcome getData() {
        return this.data;
    }

    public final void setData(final ResWelcome data) {
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
        return "ResWelcomeContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
