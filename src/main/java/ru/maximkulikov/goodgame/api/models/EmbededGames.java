package ru.maximkulikov.goodgame.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededGames {

    private List<Game> games;

    /**
     * @return games
     */
    public final List<Game> getGames() {
        return this.games;
    }

    public final void setGames(final List<Game> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EmbededGames that = (EmbededGames) o;

        return new EqualsBuilder()
                .append(games, that.games)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(games)
                .toHashCode();
    }

    @Override
    public final String toString() {
        return "EmbededGames{" +
                "games=" + this.games +
                '}';
    }
}
