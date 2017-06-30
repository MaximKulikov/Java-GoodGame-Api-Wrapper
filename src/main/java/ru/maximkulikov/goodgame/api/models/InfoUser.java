package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoUser {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("username")
    private String userName;

    /**
     * @returnuser_id
     */
    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * @return username
     */
    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public final String toString() {
        return "InfoUser{" +
                "userName='" + this.userName + '\'' +
                ", userId='" + this.userId + '\'' +
                '}';
    }
}
