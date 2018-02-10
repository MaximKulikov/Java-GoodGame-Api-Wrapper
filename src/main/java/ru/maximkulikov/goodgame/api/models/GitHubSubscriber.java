package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubSubscriber {

    private String id;

    private String sign;

    private String username;

    @JsonProperty("created_at")
    private String createdAt;

}
