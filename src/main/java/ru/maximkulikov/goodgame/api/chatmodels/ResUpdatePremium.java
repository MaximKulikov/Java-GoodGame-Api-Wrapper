package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdatePremium implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private Boolean premium;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResUpdatePremium that = (ResUpdatePremium) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(premium, that.premium)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(premium)
                .toHashCode();
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final Boolean getPremium() {
        return this.premium;
    }

    public final void setPremium(final Boolean premium) {
        this.premium = premium;
    }

    @Override
    public final String toString() {
        return "ResUpdatePremium{" +
                "channelId='" + this.channelId + '\'' +
                ", premium=" + this.premium +
                '}';
    }
}
