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

    public final List<Game> getGames() {
        return games;
    }

    public final void setGames(final List<Game> games) {
        this.games = games;
    }

    @Override
    public final String toString() {
        return "EmbededGames{" +
                "games=" + games +
                '}';
    }
}
