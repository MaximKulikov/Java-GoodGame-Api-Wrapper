package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 20.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResModeratorRightContainer {

    private String type;

    private ResModeratorRight data;

    public final ResModeratorRight getData() {
        return this.data;
    }

    public final void setData(final ResModeratorRight data) {
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
        return "ResModeratorRightContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
