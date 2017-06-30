package ru.maximkulikov.goodgame.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededSubscribers {

    private List<Subscrurer> subscribers;

    /**
     * @return subscribers
     */
    public final List<Subscrurer> getSubscribers() {
        return this.subscribers;
    }

    public final void setSubscribers(final List<Subscrurer> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public final String toString() {
        return "EmbededSubscribers{" +
                "subscribers=" + this.subscribers +
                '}';
    }
}
