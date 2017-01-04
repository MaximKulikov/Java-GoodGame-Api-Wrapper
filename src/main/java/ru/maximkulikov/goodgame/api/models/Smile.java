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

    @Override
    public String toString() {
        return "Smile{" +
                "key='" + key + '\'' +
                ", donateLvl=" + donateLvl +
                ", premium=" + premium +
                ", paid=" + paid +
                ", channelId='" + channelId + '\'' +
                ", urls=" + urls +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getDonateLvl() {
        return donateLvl;
    }

    public void setDonateLvl(Long donateLvl) {
        this.donateLvl = donateLvl;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public SmileUrls getUrls() {
        return urls;
    }

    public void setUrls(SmileUrls urls) {
        this.urls = urls;
    }
}
