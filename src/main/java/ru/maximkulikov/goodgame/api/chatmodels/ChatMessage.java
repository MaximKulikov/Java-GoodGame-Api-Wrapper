package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMessage {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_group")
    private Long userGroup;

    @JsonProperty("message_id")
    private String messageId;

    private String timestamp;

    private String text;

    public final String getMessageId() {
        return messageId;
    }

    public final void setMessageId(final String messageId) {
        this.messageId = messageId;
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

    public final Long getUserGroup() {
        return userGroup;
    }

    public final void setUserGroup(final Long userGroup) {
        this.userGroup = userGroup;
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

    @Override
    public final String toString() {
        return "ChatMessage{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userGroup=" + userGroup +
                ", messageId='" + messageId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}