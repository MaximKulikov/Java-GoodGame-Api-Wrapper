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
public class ResChannelCounters implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("clients_in_channel")
    private Long clientsInChannel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResChannelCounters that = (ResChannelCounters) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(clientsInChannel, that.clientsInChannel)
                .append(usersInChannel, that.usersInChannel)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(clientsInChannel)
                .append(usersInChannel)
                .toHashCode();
    }

    @JsonProperty("users_in_channel")
    private Long usersInChannel;

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

    public final Long getUsersInChannel() {
        return this.usersInChannel;
    }

    public final void setUsersInChannel(final Long usersInChannel) {
        this.usersInChannel = usersInChannel;
    }

    @Override
    public final String toString() {
        return "ResChannelCounters{" +
                "channelId='" + this.channelId + '\'' +
                ", clientsInChannel=" + this.clientsInChannel +
                ", usersInChannel=" + this.usersInChannel +
                '}';
    }
}
