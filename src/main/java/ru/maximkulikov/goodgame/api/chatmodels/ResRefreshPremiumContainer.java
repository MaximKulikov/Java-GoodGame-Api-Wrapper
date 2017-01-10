package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResRefreshPremiumContainer {
    private String type;
    private ResRefreshPremium data;

    public ResRefreshPremium getData() {
        return data;
    }

    public void setData(ResRefreshPremium data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ResRefreshPremiumContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
