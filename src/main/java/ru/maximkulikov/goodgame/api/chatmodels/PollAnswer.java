package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollAnswer {

    private int id;

    private String text;

    public PollAnswer(final int id, final String text) {
        this.id = id;
        this.text = text;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    @Override
    public final String toString() {
        return "PollAnswer{" +
                "id='" + this.id + '\'' +
                ", text='" + this.text + '\'' +
                '}';
    }
}
