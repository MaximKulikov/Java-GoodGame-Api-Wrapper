package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResMessage  implements ResChatObject{
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

    @Override
    public String toString() {
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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserRights() {
        return userRights;
    }

    public void setUserRights(Long userRights) {
        this.userRights = userRights;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
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

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public List<String> getPaidsmiles() {
        return paidsmiles;
    }

    public void setPaidsmiles(List<String> paidsmiles) {
        this.paidsmiles = paidsmiles;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}