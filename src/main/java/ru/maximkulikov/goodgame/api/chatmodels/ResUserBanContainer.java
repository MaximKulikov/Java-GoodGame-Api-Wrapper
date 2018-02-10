package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 13.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUserBanContainer {

    private String type;

    private ResUserBan data;

}
