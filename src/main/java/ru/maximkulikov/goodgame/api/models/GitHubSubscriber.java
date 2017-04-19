package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubSubscriber {

    private String id;

    private String sign;

    private String username;

    private String created_at;

    public final String getSign() {
        return this.sign;
    }

    public final void setSign(final String sign) {
        this.sign = sign;
    }

    public final String getCreated_at() {
        return this.created_at;
    }

    public final void setCreated_at(final String created_at) {
        this.created_at = created_at;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

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
                ", created_at='" + this.created_at + '\'' +
                '}';
    }
}
