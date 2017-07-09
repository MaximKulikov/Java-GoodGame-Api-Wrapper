package ru.maximkulikov.goodgame.api.models;

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
