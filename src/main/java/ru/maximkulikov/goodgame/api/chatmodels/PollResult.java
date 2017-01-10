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

    @Override
    public String toString() {
        return "PollResult{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", voters=" + voters +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getVoters() {
        return voters;
    }

    public void setVoters(Long voters) {
        this.voters = voters;
    }
}
