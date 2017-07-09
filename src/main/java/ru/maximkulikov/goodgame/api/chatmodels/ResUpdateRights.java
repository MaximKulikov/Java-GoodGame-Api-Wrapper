package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
