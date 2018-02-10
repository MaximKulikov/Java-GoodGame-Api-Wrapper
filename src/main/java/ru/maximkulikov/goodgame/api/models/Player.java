package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 29.12.2016
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("channel_key")
    private String channelKey;

    @JsonProperty("channel_title")
    private String channelTitle;

    @JsonProperty("broadcast_title")
    private String broadcastTitle;

    @JsonProperty("channel_status")
    private String channelStatus;

    @JsonProperty("channel_poster")
    private String channelPoster;

    @JsonProperty("channel_premium")
    private String channelPremium;

    @JsonProperty("streamer_avatar")
    private String streamerAvatar;

    @JsonProperty("premium_only")
    private String premiumOnly;

    private String adult;

    @JsonProperty("channel_start")
    private String channelStart;

    @JsonProperty("ga_code")
    private String gaCode;

    private List<Broadcast> broadcasts;

    @JsonProperty("premium_prices")
    private PremiumPrices premiumPrices;

    private List<User> users;

}
