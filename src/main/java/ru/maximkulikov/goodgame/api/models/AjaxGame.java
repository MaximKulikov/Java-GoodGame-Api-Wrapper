package ru.maximkulikov.goodgame.api.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 03.04.2017
 */
public class AjaxGame {

    private String gameName;

    private String gameHtml;

    private String gameId;

    public AjaxGame(String gameName, String gameHtml, String gameId) {

        this.gameName = gameName;
        this.gameHtml = gameHtml;
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AjaxGame ajaxGame = (AjaxGame) o;

        return new EqualsBuilder()
                .append(gameName, ajaxGame.gameName)
                .append(gameHtml, ajaxGame.gameHtml)
                .append(gameId, ajaxGame.gameId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(gameName)
                .append(gameHtml)
                .append(gameId)
                .toHashCode();
    }

    /**
     * @return gameHtml
     */
    public final String getGameHtml() {
        return this.gameHtml;
    }

    /**
     * @return gameId
     */
    public final String getGameId() {
        return this.gameId;
    }

    /**
     * @return gameName
     */
    public final String getGameName() {
        return this.gameName;
    }

    @Override
    public final String toString() {
        return "Game{" +
                "gameName='" + this.gameName + '\'' +
                ", gameHtml='" + this.gameHtml + '\'' +
                ", gameId='" + this.gameId + '\'' +
                '}';
    }
}
