package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatToken {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("chat_token")
    private String chatToken;

    /**
     * @return chat_token
     */
    public final String getChatToken() {
        return this.chatToken;
    }

    public final void setChatToken(final String chatToken) {
        this.chatToken = chatToken;
    }

    /**
     * @return user_id
     */
    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public final String toString() {
        return "ChatToken{" +
                "userId='" + this.userId + '\'' +
                ", chatToken='" + this.chatToken + '\'' +
                '}';
    }
}
