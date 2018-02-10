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
public class Smile {

    private String key;

    @JsonProperty("donate_lvl")
    private Long donateLvl;

    @JsonProperty("is_premium")
    private Boolean isPremium;

    @JsonProperty("is_paid")
    private Boolean isPaid;

    @JsonProperty("channel_id")
    private String channelId;

    private SmileUrls urls;

}
