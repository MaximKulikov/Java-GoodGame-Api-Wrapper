package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 20.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResModeratorRight implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private String retMsg;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResModeratorRight that = (ResModeratorRight) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(retMsg, that.retMsg)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(retMsg)
                .toHashCode();
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getRetMsg() {
        return this.retMsg;
    }

    public final void setRetMsg(final String retMsg) {
        this.retMsg = retMsg;
    }

    @Override
    public final String toString() {
        return "ResModeratorRight{" +
                "channelId='" + this.channelId + '\'' +
                ", retMsg='" + this.retMsg + '\'' +
                '}';
    }
}
