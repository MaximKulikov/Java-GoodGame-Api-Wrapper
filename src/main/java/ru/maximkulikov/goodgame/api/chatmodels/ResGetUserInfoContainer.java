package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResGetUserInfoContainer {

    private String type;

    private ChatUser data;

}
