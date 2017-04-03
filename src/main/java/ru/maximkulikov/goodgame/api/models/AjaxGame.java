package ru.maximkulikov.goodgame.api.models;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 03.04.2017.
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

    public final String getGameHtml() {
        return this.gameHtml;
    }

    public final String getGameId() {
        return this.gameId;
    }

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
