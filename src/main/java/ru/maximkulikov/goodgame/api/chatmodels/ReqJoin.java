package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqJoin {

    @JsonProperty("channel_id")
    private String channelId;

    private boolean hidden;

    private boolean mobile;

    public ReqJoin(String channelId, boolean hidden, boolean mobile) {
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
