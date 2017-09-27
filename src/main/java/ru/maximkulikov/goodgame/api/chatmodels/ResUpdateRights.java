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
public class ResUpdateRights implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("access_rights")
    private Long accessRights;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResUpdateRights that = (ResUpdateRights) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(accessRights, that.accessRights)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(accessRights)
                .toHashCode();
    }

    public final Long getAccessRights() {
        return this.accessRights;
    }

    public final void setAccessRights(final Long accessRights) {
        this.accessRights = accessRights;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    @Override
    public final String toString() {
        return "ResUpdateRights{" +
                "channelId='" + this.channelId + '\'' +
                ", accessRights=" + this.accessRights +
                '}';
    }
}
