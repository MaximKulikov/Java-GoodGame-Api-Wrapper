package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdatePremiumContainer
{
 private String type;
 private ResUpdatePremium data;

    @Override
    public String toString() {
        return "ResUpdatePremiumContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResUpdatePremium getData() {
        return data;
    }

    public void setData(ResUpdatePremium data) {
        this.data = data;
    }
}
