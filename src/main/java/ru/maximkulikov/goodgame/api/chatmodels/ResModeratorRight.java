package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 20.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResModeratorRight implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private String retMsg;

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
