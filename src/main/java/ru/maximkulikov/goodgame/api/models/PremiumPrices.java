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
public class PremiumPrices {

    @JsonProperty("1")
    private String id1;

    @JsonProperty("2")
    private String id2;

    @JsonProperty("3")
    private String id3;

    @JsonProperty("4")
    private String id4;

    @JsonProperty("5")
    private String id5;

}
