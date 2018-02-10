package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 02.04.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateTitle {

    private String title;

    private String game;

    private String gameUrl;

}
