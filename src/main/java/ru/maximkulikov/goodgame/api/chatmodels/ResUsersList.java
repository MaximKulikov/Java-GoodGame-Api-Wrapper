package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUsersList implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("clients_in_channel")
    private Long clientsInChannel;

    @JsonProperty("users_in_channel")
    private Long usersInChannel;

    private List<ChatUser> users;

    public final String getChannelId() {
        return channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final Long getClientsInChannel() {
        return clientsInChannel;
    }

    public final void setClientsInChannel(final Long clientsInChannel) {
        this.clientsInChannel = clientsInChannel;
    }

    public final List<ChatUser> getUsers() {
        return users;
    }

    public final void setUsers(final List<ChatUser> users) {
        this.users = users;
    }

    public final Long getUsersInChannel() {
        return usersInChannel;
    }

    public final void setUsersInChannel(final Long usersInChannel) {
        this.usersInChannel = usersInChannel;
    }

    @Override
    public final String toString() {
        return "ResUsersList{" +
                "channelId='" + channelId + '\'' +
                ", clientsInChannel=" + clientsInChannel +
                ", usersInChannel=" + usersInChannel +
                ", users=" + users +
                '}';
    }
}
