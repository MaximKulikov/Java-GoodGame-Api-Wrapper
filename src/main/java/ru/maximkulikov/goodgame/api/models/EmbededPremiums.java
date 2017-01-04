package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 03.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededPremiums {
    private List<Premium> premiums;

    @Override
    public String toString() {
        return "EmbededPremiums{" +
                "premiums=" + premiums +
                '}';
    }

    public List<Premium> getPremiums() {
        return premiums;
    }

    public void setPremiums(List<Premium> premiums) {
        this.premiums = premiums;
    }
}
