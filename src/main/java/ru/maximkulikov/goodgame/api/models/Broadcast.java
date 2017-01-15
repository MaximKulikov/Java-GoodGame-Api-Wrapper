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

    public final String getBroadcastDescription() {
        return this.broadcastDescription;
    }

    public final void setBroadcastDescription(final String broadcastDescription) {
        this.broadcastDescription = broadcastDescription;
    }

    public final String getBroadcastGames() {
        return this.broadcastGames;
    }

    public final void setBroadcastGames(final String broadcastGames) {
        this.broadcastGames = broadcastGames;
    }

    public final String getBroadcastLogo() {
        return this.broadcastLogo;
    }

    public final void setBroadcastLogo(final String broadcastLogo) {
        this.broadcastLogo = broadcastLogo;
    }

    public final String getBroadcastStart() {
        return this.broadcastStart;
    }

    public final void setBroadcastStart(final String broadcastStart) {
        this.broadcastStart = broadcastStart;
    }

    public final String getBroadcastTitle() {
        return this.broadcastTitle;
    }

    public final void setBroadcastTitle(final String broadcastTitle) {
        this.broadcastTitle = broadcastTitle;
    }

    @Override
    public final String toString() {
        return "Broadcast{" +
                "broadcastTitle='" + this.broadcastTitle + '\'' +
                ", broadcastStart='" + this.broadcastStart + '\'' +
                ", broadcastGames='" + this.broadcastGames + '\'' +
                ", broadcastDescription='" + this.broadcastDescription + '\'' +
                ", broadcastLogo='" + this.broadcastLogo + '\'' +
                '}';
    }
}
