package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 12.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResWelcomeContainer {
    private String type;
private ResWelcome data;

    @Override
    public String toString() {
        return "ResWelcomeContainer{" +
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

    public ResWelcome getData() {
        return data;
    }

    public void setData(ResWelcome data) {
        this.data = data;
    }
}