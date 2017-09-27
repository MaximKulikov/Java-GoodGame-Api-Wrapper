package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResJoinToRoom implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("room_id")
    private String roomId;

    public final String getChannelId() {
        return this.channelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResJoinToRoom that = (ResJoinToRoom) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(roomId, that.roomId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(roomId)
                .toHashCode();
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final void setRoomId(final String roomId) {
        this.roomId = roomId;
    }

    @Override
    public final String toString() {
        return "ResJoinToRoom{" +
                "channelId='" + this.channelId + '\'' +
                ", roomId='" + this.roomId + '\'' +
                '}';
    }
}
