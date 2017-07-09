package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollAnswer {

    private int id;

    private String text;

    /**
     * @return id
     */
    public final int getId() {
        return this.id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    /**
     * @return text
     */
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
