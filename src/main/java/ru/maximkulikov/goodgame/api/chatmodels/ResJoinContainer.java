package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResJoinContainer {

    private String type;

    private ResJoin data;

    public final ResJoin getData() {
        return this.data;
    }

    public final void setData(final ResJoin data) {
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
        return "ResJoinContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
