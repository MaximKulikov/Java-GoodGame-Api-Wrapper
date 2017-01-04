package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelContainer {

    private String request_key;
    private Long id;

    private String key;
    private Boolean is_broadcast;
    private String broadcast_started;
    private String broadcast_end;
    private String url;
    private String status;
    private String viewers;
    private String player_viewers;
    private String users_in_chat;
    private Channel channel;

    public String getBroadcast_end() {
        return broadcast_end;
    }

    public void setBroadcast_end(String broadcast_end) {
        this.broadcast_end = broadcast_end;
    }

    public String getBroadcast_started() {
        return broadcast_started;
    }

    public void setBroadcast_started(String broadcast_started) {
        this.broadcast_started = broadcast_started;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIs_broadcast() {
        return is_broadcast;
    }

    public void setIs_broadcast(Boolean is_broadcast) {
        this.is_broadcast = is_broadcast;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPlayer_viewers() {
        return player_viewers;
    }

    public void setPlayer_viewers(String player_viewers) {
        this.player_viewers = player_viewers;
    }

    public String getRequest_key() {
        return request_key;
    }

    public void setRequest_key(String request_key) {
        this.request_key = request_key;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsers_in_chat() {
        return users_in_chat;
    }

    public void setUsers_in_chat(String users_in_chat) {
        this.users_in_chat = users_in_chat;
    }

    public String getViewers() {
        return viewers;
    }

    public void setViewers(String viewers) {
        this.viewers = viewers;
    }

    @Override
    public String toString() {
        return "ChannelContainer{" +
                "request_key='" + request_key + '\'' +
                ", id=" + id +
                ", key='" + key + '\'' +
                ", is_broadcast=" + is_broadcast +
                ", broadcast_started='" + broadcast_started + '\'' +
                ", broadcast_end='" + broadcast_end + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", viewers='" + viewers + '\'' +
                ", player_viewers='" + player_viewers + '\'' +
                ", users_in_chat='" + users_in_chat + '\'' +
                ", channel=" + channel +
                '}';
    }
}
