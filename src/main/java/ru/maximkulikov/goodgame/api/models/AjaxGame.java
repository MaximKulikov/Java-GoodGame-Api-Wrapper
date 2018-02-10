package ru.maximkulikov.goodgame.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 03.04.2017
 */
@Data
@AllArgsConstructor
public class AjaxGame {

    private String gameName;

    private String gameHtml;

    private String gameId;

}
