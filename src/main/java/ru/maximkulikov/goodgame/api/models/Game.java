package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 0.1
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    private String id;

    private String title;

    private String url;

    @JsonProperty("short")
    private String shortTitle;

    private String poster;

}
