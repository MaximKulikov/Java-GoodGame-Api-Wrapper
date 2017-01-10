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
    private Long userGroup;// на основе группы, определяется каким цветом выводить сообщения
    @JsonProperty("message_id")
    private String messageId;// номер сообщения, нужно для удаления сообщения из чата.
    private String timestamp; // время прихода сообщения на сервер.
    private String text; // оригинальное сообщение, за исключением того, что html-разметка эскейпится. Клиент сам занимается преобразованием спец. символов (например подстановка смайлов).

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Long getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Long userGroup) {
        this.userGroup = userGroup;
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

    @Override
    public String toString() {
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