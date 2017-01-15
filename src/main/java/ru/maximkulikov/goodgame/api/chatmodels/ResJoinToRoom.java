package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
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
