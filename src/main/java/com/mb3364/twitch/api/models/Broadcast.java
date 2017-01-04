package com.mb3364.twitch.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Broadcast {
    private String broadcast_title;
    private String broadcast_start;
    private String broadcast_games;
    private String broadcast_description;
    private String broadcast_logo;

    @Override
    public String toString() {
        return "Broadcast{" +
                "broadcast_logo='" + broadcast_logo + '\'' +
                ", broadcast_description='" + broadcast_description + '\'' +
                ", broadcast_games='" + broadcast_games + '\'' +
                ", broadcast_start='" + broadcast_start + '\'' +
                ", broadcast_title='" + broadcast_title + '\'' +
                '}';
    }

    public String getBroadcast_title() {
        return broadcast_title;
    }

    public void setBroadcast_title(String broadcast_title) {
        this.broadcast_title = broadcast_title;
    }

    public String getBroadcast_start() {
        return broadcast_start;
    }

    public void setBroadcast_start(String broadcast_start) {
        this.broadcast_start = broadcast_start;
    }

    public String getBroadcast_games() {
        return broadcast_games;
    }

    public void setBroadcast_games(String broadcast_games) {
        this.broadcast_games = broadcast_games;
    }

    public String getBroadcast_description() {
        return broadcast_description;
    }

    public void setBroadcast_description(String broadcast_description) {
        this.broadcast_description = broadcast_description;
    }

    public String getBroadcast_logo() {
        return broadcast_logo;
    }

    public void setBroadcast_logo(String broadcast_logo) {
        this.broadcast_logo = broadcast_logo;
    }
}
