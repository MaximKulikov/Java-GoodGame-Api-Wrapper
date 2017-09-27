package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 20.01.2017
 */
public class ResAccepted implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResAccepted that = (ResAccepted) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .toHashCode();
    }

    @Override
    public final String toString() {
        return "ResAccepted{" +
                "channelId='" + this.channelId + '\'' +
                '}';
    }
}
