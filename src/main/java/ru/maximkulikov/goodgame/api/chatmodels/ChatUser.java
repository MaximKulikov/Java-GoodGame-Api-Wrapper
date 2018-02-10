package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatUser implements ResChatObject {

    private String id;

    private String name;

    private Long right;

    private Boolean premium;

    private String payments;

    private Boolean mobile;

    private Boolean hidden;

}
