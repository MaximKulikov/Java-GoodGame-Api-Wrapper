package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Broadcast {
    @JsonProperty("broadcast_title")
    private String broadcastTitle;
    @JsonProperty("broadcast_start")
    private String broadcastStart;
    @JsonProperty("broadcast_games")
    private String broadcastGames;
    @JsonProperty("broadcast_description")
    private String broadcastDescription;
    @JsonProperty("broadcast_logo")
    private String broadcastLogo;

    public String getBroadcastDescription() {
        return broadcastDescription;
    }

    public void setBroadcastDescription(String broadcastDescription) {
        this.broadcastDescription = broadcastDescription;
    }

    public String getBroadcastGames() {
        return broadcastGames;
    }

    public void setBroadcastGames(String broadcastGames) {
        this.broadcastGames = broadcastGames;
    }

    public String getBroadcastLogo() {
        return broadcastLogo;
    }

    public void setBroadcastLogo(String broadcastLogo) {
        this.broadcastLogo = broadcastLogo;
    }

    public String getBroadcastStart() {
        return broadcastStart;
    }

    public void setBroadcastStart(String broadcastStart) {
        this.broadcastStart = broadcastStart;
    }

    public String getBroadcastTitle() {
        return broadcastTitle;
    }

    public void setBroadcastTitle(String broadcastTitle) {
        this.broadcastTitle = broadcastTitle;
    }

    @Override
    public String toString() {
        return "Broadcast{" +
                "broadcastTitle='" + broadcastTitle + '\'' +
                ", broadcastStart='" + broadcastStart + '\'' +
                ", broadcastGames='" + broadcastGames + '\'' +
                ", broadcastDescription='" + broadcastDescription + '\'' +
                ", broadcastLogo='" + broadcastLogo + '\'' +
                '}';
    }
}
