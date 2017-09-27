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
public class ChatChannel {

    @JsonProperty("channel_id")
    private String channelId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ChatChannel that = (ChatChannel) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(channelName, that.channelName)
                .append(clientsInChannel, that.clientsInChannel)
                .append(usersInChannel, that.usersInChannel)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(channelName)
                .append(clientsInChannel)
                .append(usersInChannel)
                .toHashCode();
    }

    @JsonProperty("channel_name")
    private String channelName;

    @JsonProperty("clients_in_channel")
    private Long clientsInChannel;

    @JsonProperty("users_in_channel")
    private Long usersInChannel;

    /**
     * @return channel_id
     */
    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    /**
     * @return channel_name
     */
    public final String getChannelName() {
        return this.channelName;
    }

    public final void setChannelName(final String channelName) {
        this.channelName = channelName;
    }

    /**
     * @return clients_in_channel
     */
    public final Long getClientsInChannel() {
        return this.clientsInChannel;
    }

    public final void setClientsInChannel(final Long clientsInChannel) {
        this.clientsInChannel = clientsInChannel;
    }

    /**
     * @return users_in_channel
     */
    public final Long getUsersInChannel() {
        return this.usersInChannel;
    }

    public final void setUsersInChannel(final Long usersInChannel) {
        this.usersInChannel = usersInChannel;
    }

    @Override
    public final String toString() {
        return "ChatChannel{" +
                "channelId='" + this.channelId + '\'' +
                ", channelName='" + this.channelName + '\'' +
                ", clientsInChannel=" + this.clientsInChannel +
                ", usersInChannel=" + this.usersInChannel +
                '}';
    }
}
