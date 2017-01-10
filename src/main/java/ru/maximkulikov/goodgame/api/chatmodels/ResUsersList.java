package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUsersList {
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("clients_in_channel")
    private Long clientsInChannel; // всего клиентов в канале, включая гостей
    @JsonProperty("users_in_channel")
    private Long usersInChannel;// всего авторизованных пользователей в канале
    private List<ChatUser> users; // Массив пользователей которые в данный момент находятся в канале

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Long getClientsInChannel() {
        return clientsInChannel;
    }

    public void setClientsInChannel(Long clientsInChannel) {
        this.clientsInChannel = clientsInChannel;
    }

    public List<ChatUser> getUsers() {
        return users;
    }

    public void setUsers(List<ChatUser> users) {
        this.users = users;
    }

    public Long getUsersInChannel() {
        return usersInChannel;
    }

    public void setUsersInChannel(Long usersInChannel) {
        this.usersInChannel = usersInChannel;
    }

    @Override
    public String toString() {
        return "ResUsersList{" +
                "channelId='" + channelId + '\'' +
                ", clientsInChannel=" + clientsInChannel +
                ", usersInChannel=" + usersInChannel +
                ", users=" + users +
                '}';
    }
}
