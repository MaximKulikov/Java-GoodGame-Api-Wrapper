package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoChannel {

    private String channel;

    @JsonProperty("channel_id")
    private String channelId;

    private String src;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        InfoChannel that = (InfoChannel) o;

        return new EqualsBuilder()
                .append(channel, that.channel)
                .append(channelId, that.channelId)
                .append(src, that.src)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channel)
                .append(channelId)
                .append(src)
                .toHashCode();
    }

    /**

     * @return channel
     */
    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(final String channel) {
        this.channel = channel;
    }

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
     * @return src
     */
    public final String getSrc() {
        return this.src;
    }

    public final void setSrc(final String src) {
        this.src = src;
    }

    @Override
    public final String toString() {
        return "InfoChannel{" +
                "channel='" + this.channel + '\'' +
                ", channelId='" + this.channelId + '\'' +
                ", src='" + this.src + '\'' +
                '}';
    }
}
