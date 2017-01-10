package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatChannel {
    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("channel_name")
    private String channelName; // "имя канала"

    @JsonProperty("clients_in_channel")
    private Long clientsInChannel;// всего клиентов в канале, включая гостей

    @JsonProperty("users_in_channel")
    private Long usersInChannel;  // всего авторизованных пользователей в канале

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Long getClientsInChannel() {
        return clientsInChannel;
    }

    public void setClientsInChannel(Long clientsInChannel) {
        this.clientsInChannel = clientsInChannel;
    }

    public Long getUsersInChannel() {
        return usersInChannel;
    }

    public void setUsersInChannel(Long usersInChannel) {
        this.usersInChannel = usersInChannel;
    }

    @Override
    public String toString() {
        return "ChatChannel{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", clientsInChannel=" + clientsInChannel +
                ", usersInChannel=" + usersInChannel +
                '}';
    }
}
