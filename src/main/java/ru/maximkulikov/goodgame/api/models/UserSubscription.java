package ru.maximkulikov.goodgame.api.models;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSubscription {

    @JsonProperty("_id")
    private String id;

    private Date createdAt;

    private ChannelContainer channel;

    public final ChannelContainer getChannel() {
        return this.channel;
    }

    public final void setChannel(final ChannelContainer channel) {
        this.channel = channel;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    @Override
    public final int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserSubscription that = (UserSubscription) o;

        return !(this.id != null ? !this.id.equals(that.id) : that.id != null);

    }

    @Override
    public final String toString() {
        return "UserSubscription{" +
                "id='" + this.id + '\'' +
                ", createdAt=" + this.createdAt +
                ", channel=" + this.channel +
                '}';
    }
}
