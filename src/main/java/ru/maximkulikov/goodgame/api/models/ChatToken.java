package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ChatToken chatToken1 = (ChatToken) o;

        return new EqualsBuilder()
                .append(userId, chatToken1.userId)
                .append(chatToken, chatToken1.chatToken)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(userId)
                .append(chatToken)
                .toHashCode();
    }

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
