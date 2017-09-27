package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulkov
 * @since 08.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqJoin {

    @JsonProperty("channel_id")
    private String channelId;

    private boolean hidden;

    private boolean mobile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ReqJoin reqJoin = (ReqJoin) o;

        return new EqualsBuilder()
                .append(hidden, reqJoin.hidden)
                .append(mobile, reqJoin.mobile)
                .append(channelId, reqJoin.channelId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(hidden)
                .append(mobile)
                .toHashCode();
    }

    /**
     * @param channelId channel_id
     * @param hidden    hidden
     * @param mobile    mobile
     */
    public ReqJoin(final String channelId, final boolean hidden, final boolean mobile) {
        this.channelId = channelId;
        this.hidden = hidden;
        this.mobile = mobile;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final boolean getHidden() {
        return this.hidden;
    }

    public final void setHidden(final boolean hidden) {
        this.hidden = hidden;
    }

    public final boolean getMobile() {
        return this.mobile;
    }

    public final void setMobile(final boolean mobile) {
        this.mobile = mobile;
    }

    @Override
    public final String toString() {
        return "ReqJoin{" +
                "channelId='" + this.channelId + '\'' +
                ", hidden=" + this.hidden +
                ", mobile=" + this.mobile +
                '}';
    }
}
