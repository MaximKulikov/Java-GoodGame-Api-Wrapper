package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 03.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededSubscribers {
    private List<Subscrurer> subscribers;

    @Override
    public String toString() {
        return "EmbededSubscribers{" +
                "subscribers=" + subscribers +
                '}';
    }

    public List<Subscrurer> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscrurer> subscribers) {
        this.subscribers = subscribers;
    }
}
