package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
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
    private PremiumPrices premiumPrices;
    private List<User> users;

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getBroadcastTitle() {
        return broadcastTitle;
    }

    public void setBroadcastTitle(String broadcastTitle) {
        this.broadcastTitle = broadcastTitle;
    }

    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    public void setBroadcasts(List<Broadcast> broadcasts) {
        this.broadcasts = broadcasts;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public String getChannelPoster() {
        return channelPoster;
    }

    public void setChannelPoster(String channelPoster) {
        this.channelPoster = channelPoster;
    }

    public String getChannelPremium() {
        return channelPremium;
    }

    public void setChannelPremium(String channelPremium) {
        this.channelPremium = channelPremium;
    }

    public String getChannelStart() {
        return channelStart;
    }

    public void setChannelStart(String channelStart) {
        this.channelStart = channelStart;
    }

    public String getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(String channelStatus) {
        this.channelStatus = channelStatus;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getGaCode() {
        return gaCode;
    }

    public void setGaCode(String gaCode) {
        this.gaCode = gaCode;
    }

    public String getPremiumOnly() {
        return premiumOnly;
    }

    public void setPremiumOnly(String premiumOnly) {
        this.premiumOnly = premiumOnly;
    }

    public PremiumPrices getPremiumPrices() {
        return premiumPrices;
    }

    public void setPremiumPrices(PremiumPrices premiumPrices) {
        this.premiumPrices = premiumPrices;
    }

    public String getStreamerAvatar() {
        return streamerAvatar;
    }

    public void setStreamerAvatar(String streamerAvatar) {
        this.streamerAvatar = streamerAvatar;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Player{" +
                "channelId='" + channelId + '\'' +
                ", channelKey='" + channelKey + '\'' +
                ", channelTitle='" + channelTitle + '\'' +
                ", broadcastTitle='" + broadcastTitle + '\'' +
                ", channelStatus='" + channelStatus + '\'' +
                ", channelPoster='" + channelPoster + '\'' +
                ", channelPremium='" + channelPremium + '\'' +
                ", streamerAvatar='" + streamerAvatar + '\'' +
                ", premiumOnly='" + premiumOnly + '\'' +
                ", adult='" + adult + '\'' +
                ", channelStart='" + channelStart + '\'' +
                ", gaCode='" + gaCode + '\'' +
                ", broadcasts=" + broadcasts +
                ", premiumPrices=" + premiumPrices +
                ", users=" + users +
                '}';
    }
}
