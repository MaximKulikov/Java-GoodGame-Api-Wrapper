package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {
    private String channel_id;
    private String channel_key;
    private String channel_title;
    private String broadcast_title;
    private String channel_status;
    private String channel_poster;
    private String channel_premium;
    private String streamer_avatar;
    private String premium_only;
    private String adult;
    private String channel_start;
    private String ga_code;
    private List<Broadcast> broadcasts;
    private PremiumPrices premiumPrices;
    private List<User> users;

    @Override
    public String toString() {
        return "Player{" +
                "channel_id='" + channel_id + '\'' +
                ", channel_key='" + channel_key + '\'' +
                ", channel_title='" + channel_title + '\'' +
                ", broadcast_title='" + broadcast_title + '\'' +
                ", channel_status='" + channel_status + '\'' +
                ", channel_poster='" + channel_poster + '\'' +
                ", channel_premium='" + channel_premium + '\'' +
                ", streamer_avatar='" + streamer_avatar + '\'' +
                ", premium_only='" + premium_only + '\'' +
                ", adult='" + adult + '\'' +
                ", channel_start='" + channel_start + '\'' +
                ", ga_code='" + ga_code + '\'' +
                ", broadcast=" + broadcasts +
                ", premiumPrices=" + premiumPrices +
                ", user=" + users +
                '}';
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_key() {
        return channel_key;
    }

    public void setChannel_key(String channel_key) {
        this.channel_key = channel_key;
    }

    public String getChannel_title() {
        return channel_title;
    }

    public void setChannel_title(String channel_title) {
        this.channel_title = channel_title;
    }

    public String getBroadcast_title() {
        return broadcast_title;
    }

    public void setBroadcast_title(String broadcast_title) {
        this.broadcast_title = broadcast_title;
    }

    public String getChannel_status() {
        return channel_status;
    }

    public void setChannel_status(String channel_status) {
        this.channel_status = channel_status;
    }

    public String getChannel_poster() {
        return channel_poster;
    }

    public void setChannel_poster(String channel_poster) {
        this.channel_poster = channel_poster;
    }

    public String getChannel_premium() {
        return channel_premium;
    }

    public void setChannel_premium(String channel_premium) {
        this.channel_premium = channel_premium;
    }

    public String getStreamer_avatar() {
        return streamer_avatar;
    }

    public void setStreamer_avatar(String streamer_avatar) {
        this.streamer_avatar = streamer_avatar;
    }

    public String getPremium_only() {
        return premium_only;
    }

    public void setPremium_only(String premium_only) {
        this.premium_only = premium_only;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChannel_start() {
        return channel_start;
    }

    public void setChannel_start(String channel_start) {
        this.channel_start = channel_start;
    }

    public String getGa_code() {
        return ga_code;
    }

    public void setGa_code(String ga_code) {
        this.ga_code = ga_code;
    }

    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    public void setBroadcasts(List<Broadcast> broadcasts) {
        this.broadcasts = broadcasts;
    }

    public PremiumPrices getPremiumPrices() {
        return premiumPrices;
    }

    public void setPremiumPrices(PremiumPrices premiumPrices) {
        this.premiumPrices = premiumPrices;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
