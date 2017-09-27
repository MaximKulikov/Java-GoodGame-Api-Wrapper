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
public class ResModeratorsList implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private List<ChatUser> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResModeratorsList that = (ResModeratorsList) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(users, that.users)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(users)
                .toHashCode();
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final List<ChatUser> getUsers() {
        return this.users;
    }

    public final void setUsers(final List<ChatUser> users) {
        this.users = users;
    }

    @Override
    public final String toString() {
        return "ResModeratorsList{" +
                "channelId='" + this.channelId + '\'' +
                ", users=" + this.users +
                '}';
    }
}
