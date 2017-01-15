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

    public final String getAdult() {
        return this.adult;
    }

    public final void setAdult(final String adult) {
        this.adult = adult;
    }

    public final String getBroadcastTitle() {
        return this.broadcastTitle;
    }

    public final void setBroadcastTitle(final String broadcastTitle) {
        this.broadcastTitle = broadcastTitle;
    }

    public final List<Broadcast> getBroadcasts() {
        return this.broadcasts;
    }

    public final void setBroadcasts(final List<Broadcast> broadcasts) {
        this.broadcasts = broadcasts;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getChannelKey() {
        return this.channelKey;
    }

    public final void setChannelKey(final String channelKey) {
        this.channelKey = channelKey;
    }

    public final String getChannelPoster() {
        return this.channelPoster;
    }

    public final void setChannelPoster(final String channelPoster) {
        this.channelPoster = channelPoster;
    }

    public final String getChannelPremium() {
        return this.channelPremium;
    }

    public final void setChannelPremium(final String channelPremium) {
        this.channelPremium = channelPremium;
    }

    public String getChannelStart() {
        return this.channelStart;
    }

    public final void setChannelStart(final String channelStart) {
        this.channelStart = channelStart;
    }

    public final String getChannelStatus() {
        return this.channelStatus;
    }

    public final void setChannelStatus(final String channelStatus) {
        this.channelStatus = channelStatus;
    }

    public final String getChannelTitle() {
        return this.channelTitle;
    }

    public final void setChannelTitle(final String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public final String getGaCode() {
        return this.gaCode;
    }

    public final void setGaCode(final String gaCode) {
        this.gaCode = gaCode;
    }

    public final String getPremiumOnly() {
        return this.premiumOnly;
    }

    public final void setPremiumOnly(final String premiumOnly) {
        this.premiumOnly = premiumOnly;
    }

    public final PremiumPrices getPremiumPrices() {
        return this.premiumPrices;
    }

    public final void setPremiumPrices(final PremiumPrices premiumPrices) {
        this.premiumPrices = premiumPrices;
    }

    public final String getStreamerAvatar() {
        return this.streamerAvatar;
    }

    public final void setStreamerAvatar(final String streamerAvatar) {
        this.streamerAvatar = streamerAvatar;
    }

    public final List<User> getUsers() {
        return this.users;
    }

    public final void setUsers(final List<User> users) {
        this.users = users;
    }

    @Override
    public final String toString() {
        return "Player{" +
                "channelId='" + this.channelId + '\'' +
                ", channelKey='" + this.channelKey + '\'' +
                ", channelTitle='" + this.channelTitle + '\'' +
                ", broadcastTitle='" + this.broadcastTitle + '\'' +
                ", channelStatus='" + this.channelStatus + '\'' +
                ", channelPoster='" + this.channelPoster + '\'' +
                ", channelPremium='" + this.channelPremium + '\'' +
                ", streamerAvatar='" + this.streamerAvatar + '\'' +
                ", premiumOnly='" + this.premiumOnly + '\'' +
                ", adult='" + this.adult + '\'' +
                ", channelStart='" + this.channelStart + '\'' +
                ", gaCode='" + this.gaCode + '\'' +
                ", broadcasts=" + this.broadcasts +
                ", premiumPrices=" + this.premiumPrices +
                ", users=" + this.users +
                '}';
    }
}
