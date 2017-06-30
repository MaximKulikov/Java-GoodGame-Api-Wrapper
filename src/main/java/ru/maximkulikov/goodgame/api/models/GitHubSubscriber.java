package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubSubscriber {

    private String id;

    private String sign;

    private String username;

    @JsonProperty("created_at")
    private String createdAt;

    /**
     * @return sign
     */
    public final String getSign() {
        return this.sign;
    }

    public final void setSign(final String sign) {
        this.sign = sign;
    }

    /**
     * @return created_at
     */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return id
     */
    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(final String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "GitHubSubscriber{" +
                "id='" + this.id + '\'' +
                ", sign='" + this.sign + '\'' +
                ", username='" + this.username + '\'' +
                ", createdAt='" + this.createdAt + '\'' +
                '}';
    }
}
