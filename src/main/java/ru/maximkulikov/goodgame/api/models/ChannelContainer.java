package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelContainer {
    @JsonProperty("request_key")
    private String requestKey;
    private Long id;
    private String key;
    @JsonProperty("is_broadcast")
    private Boolean isBroadcast;
    @JsonProperty("broadcast_started")
    private String broadcastStarted;
    @JsonProperty("broadcast_end")
    private String broadcastEnd;
    private String url;
    private String status;
    private String viewers;
    @JsonProperty("player_viewers")
    private String playerViewers;
    @JsonProperty("users_in_chat")
    private String usersInChat;
    private Channel channel;

    public Boolean getBroadcast() {
        return isBroadcast;
    }

    public void setBroadcast(Boolean broadcast) {
        isBroadcast = broadcast;
    }

    public String getBroadcastEnd() {
        return broadcastEnd;
    }

    public void setBroadcastEnd(String broadcastEnd) {
        this.broadcastEnd = broadcastEnd;
    }

    public String getBroadcastStarted() {
        return broadcastStarted;
    }

    public void setBroadcastStarted(String broadcastStarted) {
        this.broadcastStarted = broadcastStarted;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPlayerViewers() {
        return playerViewers;
    }

    public void setPlayerViewers(String playerViewers) {
        this.playerViewers = playerViewers;
    }

    public String getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
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

    public String getUsersInChat() {
        return usersInChat;
    }

    public void setUsersInChat(String usersInChat) {
        this.usersInChat = usersInChat;
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
                "requestKey='" + requestKey + '\'' +
                ", id=" + id +
                ", key='" + key + '\'' +
                ", isBroadcast=" + isBroadcast +
                ", broadcastStarted='" + broadcastStarted + '\'' +
                ", broadcastEnd='" + broadcastEnd + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", viewers='" + viewers + '\'' +
                ", playerViewers='" + playerViewers + '\'' +
                ", usersInChat='" + usersInChat + '\'' +
                ", channel=" + channel +
                '}';
    }
}
