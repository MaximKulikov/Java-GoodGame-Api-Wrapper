package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 14.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdateGroups implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private List<String> groups;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResUpdateGroups that = (ResUpdateGroups) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(groups, that.groups)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(groups)
                .toHashCode();
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final void setGroups(final List<String> groups) {
        this.groups = groups;
    }

    @Override
    public final String toString() {
        return "ResUpdateGroups{" +
                "channelId='" + this.channelId + '\'' +
                ", groups=" + this.groups +
                '}';
    }
}
