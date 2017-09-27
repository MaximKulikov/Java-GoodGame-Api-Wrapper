package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelContainer {

    @JsonProperty("request_key")
    private String requestKey;

    private Long id;

    private String key;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ChannelContainer that = (ChannelContainer) o;

        return new EqualsBuilder()
                .append(requestKey, that.requestKey)
                .append(id, that.id)
                .append(key, that.key)
                .append(isBroadcast, that.isBroadcast)
                .append(broadcastStarted, that.broadcastStarted)
                .append(broadcastEnd, that.broadcastEnd)
                .append(url, that.url)
                .append(status, that.status)
                .append(viewers, that.viewers)
                .append(playerViewers, that.playerViewers)
                .append(usersInChat, that.usersInChat)
                .append(channel, that.channel)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(requestKey)
                .append(id)
                .append(key)
                .append(isBroadcast)
                .append(broadcastStarted)
                .append(broadcastEnd)
                .append(url)
                .append(status)
                .append(viewers)
                .append(playerViewers)
                .append(usersInChat)
                .append(channel)
                .toHashCode();
    }

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

    /**
     * @return is_broadcast
     */
    public final Boolean getBroadcast() {
        return this.isBroadcast;
    }

    public final void setBroadcast(final Boolean broadcast) {
        this.isBroadcast = broadcast;
    }

    /**
     * @return broadcast_end
     */
    public final Long getBroadcastEnd() {
        return this.broadcastEnd;
    }

    public final void setBroadcastEnd(final Long broadcastEnd) {
        this.broadcastEnd = broadcastEnd;
    }

    /**
     * @return broadcast_started
     */
    public final Long getBroadcastStarted() {
        return this.broadcastStarted;
    }

    public final void setBroadcastStarted(final Long broadcastStarted) {
        this.broadcastStarted = broadcastStarted;
    }

    /**
     * @return channel
     */
    public final Channel getChannel() {
        return this.channel;
    }

    public final void setChannel(final Channel channel) {
        this.channel = channel;
    }

    /**
     * @return id
     */
    public final Long getId() {
        return this.id;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return key
     */
    public final String getKey() {
        return this.key;
    }

    public final void setKey(final String key) {
        this.key = key;
    }

    /**
     * @return player_viewers
     */
    public final String getPlayerViewers() {
        return this.playerViewers;
    }

    public final void setPlayerViewers(final String playerViewers) {
        this.playerViewers = playerViewers;
    }

    /**
     * @return request_key
     */
    public final String getRequestKey() {
        return this.requestKey;
    }

    public final void setRequestKey(final String requestKey) {
        this.requestKey = requestKey;
    }

    /**
     * @return status
     */
    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @return url
     */
    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(final String url) {
        this.url = url;
    }

    /**
     * @return users_in_chat
     */
    public final String getUsersInChat() {
        return this.usersInChat;
    }

    public final void setUsersInChat(final String usersInChat) {
        this.usersInChat = usersInChat;
    }

    /**
     * @return viewers
     */
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
