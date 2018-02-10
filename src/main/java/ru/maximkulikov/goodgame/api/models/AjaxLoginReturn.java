package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 03.04.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxLoginReturn {

    private String id;

    private String username;

    private String avatar;

    private String token;

    private AjaxChannel channel;

    private AjaxSettings settings;

    private Integer dialogs;

    private Boolean bl;

    private String rights;

    private Boolean premium;

}
