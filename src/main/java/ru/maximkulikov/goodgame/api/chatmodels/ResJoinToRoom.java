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
    private String channelId; // id-канала, из которого посылалась inline-команда /join
    @JsonProperty("room_id")
    private String roomId; // id-канала или если начинается с префикса "r" id-комнаты

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "ResJoinToRoom{" +
                "channelId='" + channelId + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
