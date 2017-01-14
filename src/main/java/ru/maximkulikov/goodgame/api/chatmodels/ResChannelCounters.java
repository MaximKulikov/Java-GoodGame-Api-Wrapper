package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelCounters implements ResChatObject {

    @JsonProperty("channel_id")
    private String channel_id;

    @JsonProperty("clients_in_channel")
    private Long clientsInChannel;

    @JsonProperty("users_in_channel")
    private Long usersInChannel;

    public final String getChannel_id() {
        return channel_id;
    }

    public final void setChannel_id(final String channel_id) {
        this.channel_id = channel_id;
    }

    public final Long getClientsInChannel() {
        return clientsInChannel;
    }

    public final void setClientsInChannel(final Long clientsInChannel) {
        this.clientsInChannel = clientsInChannel;
    }

    public final Long getUsersInChannel() {
        return usersInChannel;
    }

    public final void setUsersInChannel(final Long usersInChannel) {
        this.usersInChannel = usersInChannel;
    }

    @Override
    public final String toString() {
        return "ResChannelCounters{" +
                "channel_id='" + channel_id + '\'' +
                ", clientsInChannel=" + clientsInChannel +
                ", usersInChannel=" + usersInChannel +
                '}';
    }
}
