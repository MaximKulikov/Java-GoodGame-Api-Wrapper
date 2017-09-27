package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 18.01.2017
 */
public class StreamChannelContainer {

    private List<ChannelContainer> streams;

    /**
     * @return streams
     */
    public final List<ChannelContainer> getStreams() {
        return this.streams;
    }

    public final void setStreams(final List<ChannelContainer> streams) {
        this.streams = streams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        StreamChannelContainer that = (StreamChannelContainer) o;

        return new EqualsBuilder()
                .append(streams, that.streams)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(streams)
                .toHashCode();
    }

    @Override
    public final String toString() {
        return "StreamChannelContainer{" +
                "streams=" + this.streams +
                '}';
    }
}
