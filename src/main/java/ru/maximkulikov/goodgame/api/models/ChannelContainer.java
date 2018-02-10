package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 0.1
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelContainer {

    @JsonProperty("request_key")
    private String requestKey;

    private Long id;

    private String key;

    @JsonProperty("is_broadcast")
    private Boolean isBroadcast;

    @JsonProperty("broadcast_started")
    private Long broadcastStarted;

    @JsonProperty("broadcast_end")
    private Long broadcastEnd;

    private String url;

    private String status;

    private String viewers;

    @JsonProperty("player_viewers")
    private String playerViewers;

    @JsonProperty("users_in_chat")
    private String usersInChat;

    private Channel channel;

}
