package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqSendMessage {

    @JsonProperty("channel_id")
    private String channelId;

    private String text;

    private boolean hideIcon;

    private boolean mobile;

    public ReqSendMessage(final String channelId, final String text, final boolean hideIcon, final boolean mobile) {
        this.channelId = channelId;
        this.text = text;
        this.hideIcon = hideIcon;
        this.mobile = mobile;
    }

    public ReqSendMessage(final String channelId, final String text) {
        this.channelId = channelId;
        this.text = text;
        this.hideIcon = false;
        this.mobile = false;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final boolean getHideIcon() {
        return this.hideIcon;
    }

    public final void setHideIcon(final boolean hideIcon) {
        this.hideIcon = hideIcon;
    }

    public final boolean getMobile() {
        return this.mobile;
    }

    public final void setMobile(final boolean mobile) {
        this.mobile = mobile;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    @Override
    public final String toString() {
        return "ReqSendMessage{" +
                "channelId='" + this.channelId + '\'' +
                ", text='" + this.text + '\'' +
                ", hideIcon=" + this.hideIcon +
                ", mobile=" + this.mobile +
                '}';
    }
}
