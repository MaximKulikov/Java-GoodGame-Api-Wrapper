package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResUsersList that = (ResUsersList) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(clientsInChannel, that.clientsInChannel)
                .append(usersInChannel, that.usersInChannel)
                .append(users, that.users)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(clientsInChannel)
                .append(usersInChannel)
                .append(users)
                .toHashCode();
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final Long getClientsInChannel() {
        return this.clientsInChannel;
    }

    public final void setClientsInChannel(final Long clientsInChannel) {
        this.clientsInChannel = clientsInChannel;
    }

    public final List<ChatUser> getUsers() {
        return this.users;
    }

    public final void setUsers(final List<ChatUser> users) {
        this.users = users;
    }

    public final Long getUsersInChannel() {
        return this.usersInChannel;
    }

    public final void setUsersInChannel(final Long usersInChannel) {
        this.usersInChannel = usersInChannel;
    }

    @Override
    public final String toString() {
        return "ResUsersList{" +
                "channelId='" + this.channelId + '\'' +
                ", clientsInChannel=" + this.clientsInChannel +
                ", usersInChannel=" + this.usersInChannel +
                ", users=" + this.users +
                '}';
    }
}
