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
        return channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getColor() {
        return color;
    }

    public final void setColor(final String color) {
        this.color = color;
    }

    public final Boolean getHideIcon() {
        return hideIcon;
    }

    public final void setHideIcon(final Boolean hideIcon) {
        this.hideIcon = hideIcon;
    }

    public final String getMessageId() {
        return messageId;
    }

    public final void setMessageId(final String messageId) {
        this.messageId = messageId;
    }

    public final Boolean getMobile() {
        return mobile;
    }

    public final void setMobile(final Boolean mobile) {
        this.mobile = mobile;
    }

    public final List<String> getPaidsmiles() {
        return paidsmiles;
    }

    public final void setPaidsmiles(final List<String> paidsmiles) {
        this.paidsmiles = paidsmiles;
    }

    public final String getPayments() {
        return payments;
    }

    public final void setPayments(final String payments) {
        this.payments = payments;
    }

    public final Boolean getPremium() {
        return premium;
    }

    public final void setPremium(final Boolean premium) {
        this.premium = premium;
    }

    public final String getText() {
        return text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    public final String getTimestamp() {
        return timestamp;
    }

    public final void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

    public final String getUserId() {
        return userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    public final String getUserName() {
        return userName;
    }

    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    public final Long getUserRights() {
        return userRights;
    }

    public final void setUserRights(final Long userRights) {
        this.userRights = userRights;
    }

    @Override
    public final String toString() {
        return "ResMessage{" +
                "channelId='" + channelId + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userRights=" + userRights +
                ", premium=" + premium +
                ", hideIcon=" + hideIcon +
                ", mobile=" + mobile +
                ", payments='" + payments + '\'' +
                ", paidsmiles=" + paidsmiles +
                ", messageId='" + messageId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", color='" + color + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}