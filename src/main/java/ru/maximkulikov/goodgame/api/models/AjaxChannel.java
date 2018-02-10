package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 03.04.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxChannel {

    private String id;

    private String link;

}
