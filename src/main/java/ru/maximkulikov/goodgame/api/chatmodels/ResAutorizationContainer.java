package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 08.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResAutorizationContainer {

    private String type;

    private ResAutorization data;

    public final ResAutorization getData() {
        return this.data;
    }

    public final void setData(final ResAutorization data) {
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
        return "ResAutorizationContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
