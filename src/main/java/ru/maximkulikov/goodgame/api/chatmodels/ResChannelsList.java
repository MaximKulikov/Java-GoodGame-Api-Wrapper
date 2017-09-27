package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelsList implements ResChatObject {

    private List<ChatChannel> channels;

    public final List<ChatChannel> getChannels() {
        return this.channels;
    }

    public final void setChannels(final List<ChatChannel> channels) {
        this.channels = channels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResChannelsList that = (ResChannelsList) o;

        return new EqualsBuilder()
                .append(channels, that.channels)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channels)
                .toHashCode();
    }

    @Override
    public final String toString() {
        return "ResChannelsList{" +
                "channels=" + this.channels +
                '}';
    }
}
