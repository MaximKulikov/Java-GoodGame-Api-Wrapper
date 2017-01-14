package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollResult {

    private int id;

    private String text;

    private Long voters;

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

    public final Long getVoters() {
        return voters;
    }

    public final void setVoters(final Long voters) {
        this.voters = voters;
    }

    @Override
    public final String toString() {
        return "PollResult{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", voters=" + voters +
                '}';
    }
}
