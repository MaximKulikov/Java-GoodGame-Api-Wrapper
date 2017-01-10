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
    private Boolean hideIcon;
    private Boolean mobile;

    public ReqSendMessage(String channelId, String text, Boolean hideIcon, Boolean mobile) {
        this.channelId = channelId;
        this.text = text;
        this.hideIcon = hideIcon;
        this.mobile = mobile;
    }

    public ReqSendMessage(String channelId, String text) {
        this.channelId = channelId;
        this.text = text;
        this.hideIcon = false;
        this.mobile = false;
    }

    @Override
    public String toString() {
        return "ReqSendMessage{" +
                "channelId='" + channelId + '\'' +
                ", text='" + text + '\'' +
                ", hideIcon=" + hideIcon +
                ", mobile=" + mobile +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getHideIcon() {
        return hideIcon;
    }

    public void setHideIcon(Boolean hideIcon) {
        this.hideIcon = hideIcon;
    }

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }
}
