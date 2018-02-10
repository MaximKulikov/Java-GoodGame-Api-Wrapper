package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 20.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResAcceptedContainer {

    private String type;

    private ResAccepted data;

}
