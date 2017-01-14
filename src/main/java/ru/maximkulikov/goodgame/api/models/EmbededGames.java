package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededGames {
    private List<Game> games;

    @Override
    public String toString() {
        return "EmbededGames{" +
                "games=" + games +
                '}';
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
