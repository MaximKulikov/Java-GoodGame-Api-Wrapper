package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 08.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResAutorization implements ResChatObject {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_name")
    private String userName;

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

    @Override
    public final String toString() {
        return "ResAutorization{" +
                "userId='" + this.userId + '\'' +
                ", userName='" + this.userName + '\'' +
                '}';
    }
}
