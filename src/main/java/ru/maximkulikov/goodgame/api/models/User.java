package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 29.12.2016
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("user_id")
    private String userId;

    private String secure;

    private String email;

    private String payments;

    private String subscribed;

    @JsonProperty("subscribed_stream")
    private String subscribedStream;

    @JsonProperty("subscribed_anons")
    private String subscribedAnons;

    private String wallet;

}
