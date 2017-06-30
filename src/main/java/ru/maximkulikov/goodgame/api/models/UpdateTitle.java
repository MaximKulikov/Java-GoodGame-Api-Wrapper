package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 02.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateTitle {

    private String title;

    private String game;

    private String gameUrl;

    /**
     * @return game
     */
    public final String getGame() {
        return this.game;
    }

    public final void setGame(final String game) {
        this.game = game;
    }

    /**
     * @return gameUrl
     */
    public final String getGameUrl() {
        return this.gameUrl;
    }

    public final void setGameUrl(final String gameUrl) {
        this.gameUrl = gameUrl;
    }

    /**
     * @return title
     */
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public final String toString() {
        return "UpdateTitle{" +
                "title='" + this.title + '\'' +
                ", game='" + this.game + '\'' +
                ", gameUrl='" + this.gameUrl + '\'' +
                '}';
    }
}
