package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqSendMessage {

    @JsonProperty("channel_id")
    private String channelId;

    private String text;

    private boolean hideIcon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ReqSendMessage that = (ReqSendMessage) o;

        return new EqualsBuilder()
                .append(hideIcon, that.hideIcon)
                .append(mobile, that.mobile)
                .append(channelId, that.channelId)
                .append(text, that.text)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(text)
                .append(hideIcon)
                .append(mobile)
                .toHashCode();
    }

    private boolean mobile;

    /**
     * @param channelId channel_id
     * @param text      text
     * @param hideIcon  hideIcon
     * @param mobile    mobile
     */
    public ReqSendMessage(final String channelId, final String text, final boolean hideIcon, final boolean mobile) {
        this.channelId = channelId;
        this.text = text;
        this.hideIcon = hideIcon;
        this.mobile = mobile;
    }

    /**
     * @param channelId channel_id
     * @param text      text
     */
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
