package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 14.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResSettingsContainer {

    private String type;

    private ResSettings data;

}
