package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResPollResultsContainer {
    private String type;
    private ResPollResults data;

    @Override
    public String toString() {
        return "ResPollResultsContainer{" +
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

    public ResPollResults getData() {
        return data;
    }

    public void setData(ResPollResults data) {
        this.data = data;
    }
}
