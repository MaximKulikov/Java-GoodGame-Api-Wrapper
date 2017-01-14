package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 14.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResSettingsContainer {

    private String type;

    private ResSettings data;

    public final String getType() {
        return this.type;
    }

    public void setType( final String type) {
        this.type = type;
    }

    public final  ResSettings getData() {
        return this.data;
    }

    public void setData( final ResSettings data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResSettingsContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
