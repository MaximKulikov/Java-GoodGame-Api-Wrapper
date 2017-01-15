package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResPremiumContainer {

    private String type;

    private ResPremium data;

    public final ResPremium getData() {
        return data;
    }

    public final void setData(final ResPremium data) {
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
        return "ResPremiumContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}