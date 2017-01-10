package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResIgnoreListContainer {
    private String type;
    private ResIgnoreList data;

    public ResIgnoreList getData() {
        return data;
    }

    public void setData(ResIgnoreList data) {
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
        return "ResIgnoreListContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
