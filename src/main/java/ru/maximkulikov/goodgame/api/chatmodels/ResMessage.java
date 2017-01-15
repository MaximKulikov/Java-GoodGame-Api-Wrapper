package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResMessage implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_rights")
    private Long userRights;

    private Boolean premium;

    private Boolean hideIcon;

    private Boolean mobile;

    private String payments;

    private List<String> paidsmiles;

    @JsonProperty("message_id")
    private String messageId;

    private String timestamp;

    private String color;

    private String text;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(final String color) {
        this.color = color;
    }

    public final Boolean getHideIcon() {
        return this.hideIcon;
    }

    public final void setHideIcon(final Boolean hideIcon) {
        this.hideIcon = hideIcon;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final void setMessageId(final String messageId) {
        this.messageId = messageId;
    }

    public final Boolean getMobile() {
        return this.mobile;
    }

    public final void setMobile(final Boolean mobile) {
        this.mobile = mobile;
    }

    public final List<String> getPaidsmiles() {
        return this.paidsmiles;
    }

    public final void setPaidsmiles(final List<String> paidsmiles) {
        this.paidsmiles = paidsmiles;
    }

    public final String getPayments() {
        return this.payments;
    }

    public final void setPayments(final String payments) {
        this.payments = payments;
    }

    public final Boolean getPremium() {
        return this.premium;
    }

    public final void setPremium(final Boolean premium) {
        this.premium = premium;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    public final Long getUserRights() {
        return this.userRights;
    }

    public final void setUserRights(final Long userRights) {
        this.userRights = userRights;
    }

    @Override
    public final String toString() {
        return "ResMessage{" +
                "channelId='" + this.channelId + '\'' +
                ", userId='" + this.userId + '\'' +
                ", userName='" + this.userName + '\'' +
                ", userRights=" + this.userRights +
                ", premium=" + this.premium +
                ", hideIcon=" + this.hideIcon +
                ", mobile=" + this.mobile +
                ", payments='" + this.payments + '\'' +
                ", paidsmiles=" + this.paidsmiles +
                ", messageId='" + this.messageId + '\'' +
                ", timestamp='" + this.timestamp + '\'' +
                ", color='" + this.color + '\'' +
                ", text='" + this.text + '\'' +
                '}';
    }
}