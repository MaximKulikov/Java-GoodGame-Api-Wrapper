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
    private Long broadcastStarted;

    @JsonProperty("broadcast_end")
    private Long broadcastEnd;

    private String url;

    private String status;

    private String viewers;

    @JsonProperty("player_viewers")
    private String playerViewers;

    @JsonProperty("users_in_chat")
    private String usersInChat;

    private Channel channel;

    public final Boolean getBroadcast() {
        return this.isBroadcast;
    }

    public final void setBroadcast(final Boolean broadcast) {
        this.isBroadcast = broadcast;
    }

    public final Long getBroadcastEnd() {
        return this.broadcastEnd;
    }

    public final void setBroadcastEnd(final Long broadcastEnd) {
        this.broadcastEnd = broadcastEnd;
    }

    public final Long getBroadcastStarted() {
        return this.broadcastStarted;
    }

    public final void setBroadcastStarted(final Long broadcastStarted) {
        this.broadcastStarted = broadcastStarted;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final void setChannel(final Channel channel) {
        this.channel = channel;
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(final String key) {
        this.key = key;
    }

    public final String getPlayerViewers() {
        return this.playerViewers;
    }

    public final void setPlayerViewers(final String playerViewers) {
        this.playerViewers = playerViewers;
    }

    public final String getRequestKey() {
        return this.requestKey;
    }

    public final void setRequestKey(final String requestKey) {
        this.requestKey = requestKey;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(final String url) {
        this.url = url;
    }

    public final String getUsersInChat() {
        return this.usersInChat;
    }

    public final void setUsersInChat(final String usersInChat) {
        this.usersInChat = usersInChat;
    }

    public final String getViewers() {
        return this.viewers;
    }

    public final void setViewers(final String viewers) {
        this.viewers = viewers;
    }

    @Override
    public final String toString() {
        return "ChannelContainer{" +
                "requestKey='" + this.requestKey + '\'' +
                ", id=" + this.id +
                ", key='" + this.key + '\'' +
                ", isBroadcast=" + this.isBroadcast +
                ", broadcastStarted='" + this.broadcastStarted + '\'' +
                ", broadcastEnd='" + this.broadcastEnd + '\'' +
                ", url='" + this.url + '\'' +
                ", status='" + this.status + '\'' +
                ", viewers='" + this.viewers + '\'' +
                ", playerViewers='" + this.playerViewers + '\'' +
                ", usersInChat='" + this.usersInChat + '\'' +
                ", channel=" + this.channel +
                '}';
    }
}
