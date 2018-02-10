package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Matthew Bell
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

    @JsonProperty("title")
    private String statusText;

    @JsonProperty("status")
    private int statusCode;

    @JsonProperty("detail")
    private String message;

}
