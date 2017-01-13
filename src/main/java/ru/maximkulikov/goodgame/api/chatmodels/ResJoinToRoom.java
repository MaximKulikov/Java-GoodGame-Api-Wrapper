package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResJoinToRoom implements ResChatObject {
    private String channel_id; // id-канала, из которого посылалась inline-команда /join
    private String room_id; // id-канала или если начинается с префикса "r" id-комнаты

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "ResJoinToRoom{" +
                "channel_id='" + channel_id + '\'' +
                ", room_id='" + room_id + '\'' +
                '}';
    }
}
