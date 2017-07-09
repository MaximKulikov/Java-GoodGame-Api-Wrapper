package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdatePremiumContainer {
    private String type;

    private ResUpdatePremium data;

    public final ResUpdatePremium getData() {
        return this.data;
    }

    public final void setData(final ResUpdatePremium data) {
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
        return "ResUpdatePremiumContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}

