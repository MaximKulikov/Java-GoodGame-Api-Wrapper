package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdatePremium implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private Boolean premium;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final Boolean getPremium() {
        return this.premium;
    }

    public final void setPremium(final Boolean premium) {
        this.premium = premium;
    }

    @Override
    public final String toString() {
        return "ResUpdatePremium{" +
                "channelId='" + this.channelId + '\'' +
                ", premium=" + this.premium +
                '}';
    }
}
