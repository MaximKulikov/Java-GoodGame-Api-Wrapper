package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {

    private Long id;

    private String key;

    private String premium;

    private String title;

    @JsonProperty("max_viewers")
    private String maxViewers;

    @JsonProperty("player_type")
    private String playerType;

    @JsonProperty("gg_player_src")
    private String ggPlayerSrc;

    private String embed;

    private String img;

    private String thumb;

    private String description;

    private Boolean adult;

    private List<Game> games;

    private String url;

}
