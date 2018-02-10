package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author MaximKulikov
 * @since 29.12.2016
 */
@Data
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

}
