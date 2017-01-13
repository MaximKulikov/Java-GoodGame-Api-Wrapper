package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResAutorizationContainer   {

    private String type;
    private ResAutorization data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResAutorization getData() {
        return data;
    }

    public void setData(ResAutorization data) {
        this.data = data;
    }
}
