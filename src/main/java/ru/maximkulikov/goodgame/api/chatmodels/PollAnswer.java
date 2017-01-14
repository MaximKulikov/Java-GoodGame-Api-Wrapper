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

    public PollAnswer(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final String getText() {
        return text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "PollAnswer{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
