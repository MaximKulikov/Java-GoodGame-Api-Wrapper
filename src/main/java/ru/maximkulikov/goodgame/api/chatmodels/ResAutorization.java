package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 08.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResAutorization implements ResChatObject {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_name")
    private String userName;

}
