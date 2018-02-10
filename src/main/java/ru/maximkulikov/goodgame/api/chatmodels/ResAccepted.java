package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 20.01.2017
 */
@Data
public class ResAccepted implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

}
