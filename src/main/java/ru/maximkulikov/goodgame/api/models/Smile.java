package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Smile {

    private String key;

    @JsonProperty("donate_lvl")
    private Long donateLvl;

    @JsonProperty("is_premium")
    private Boolean premium;

    @JsonProperty("is_paid")
    private Boolean paid;

    @JsonProperty("channel_id")
    private String channelId;

    private SmileUrls urls;

    public final String getChannelId() {
        return channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final Long getDonateLvl() {
        return donateLvl;
    }

    public final void setDonateLvl(final Long donateLvl) {
        this.donateLvl = donateLvl;
    }

    public final String getKey() {
        return key;
    }

    public final void setKey(final String key) {
        this.key = key;
    }

    public final Boolean getPaid() {
        return paid;
    }

    public final void setPaid(final Boolean paid) {
        this.paid = paid;
    }

    public final Boolean getPremium() {
        return premium;
    }

    public final void setPremium(final Boolean premium) {
        this.premium = premium;
    }

    public final SmileUrls getUrls() {
        return urls;
    }

    public final void setUrls(final SmileUrls urls) {
        this.urls = urls;
    }

    @Override
    public final String toString() {
        return "Smile{" +
                "key='" + key + '\'' +
                ", donateLvl=" + donateLvl +
                ", premium=" + premium +
                ", paid=" + paid +
                ", channelId='" + channelId + '\'' +
                ", urls=" + urls +
                '}';
    }
}
