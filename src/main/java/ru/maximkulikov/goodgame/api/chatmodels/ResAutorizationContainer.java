package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 08.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResAutorizationContainer {

    private String type;

    private ResAutorization data;

}
