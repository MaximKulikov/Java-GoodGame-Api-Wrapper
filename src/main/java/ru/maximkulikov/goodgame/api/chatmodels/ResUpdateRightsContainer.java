package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdateRightsContainer {
    private String type;
    private ResUpdateRights data;

    @Override
    public String toString() {
        return "ResUpdateRightsContainer{" +
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

    public ResUpdateRights getData() {
        return data;
    }

    public void setData(ResUpdateRights data) {
        this.data = data;
    }
}