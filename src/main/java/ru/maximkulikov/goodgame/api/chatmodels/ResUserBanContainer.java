package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 13.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUserBanContainer {
    private String type;
    private ResUserBan data;

    public ResUserBan getData() {
        return data;
    }

    public void setData(ResUserBan data) {
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
        return "ResUserBanContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
