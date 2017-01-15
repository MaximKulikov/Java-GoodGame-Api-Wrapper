package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 03.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Premium {

    private String id;

    private String username;

    @JsonProperty("created_at")
    private String createdAt;

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
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
    public final String toString() {
        return "Premium{" +
                "id='" + this.id + '\'' +
                ", username='" + this.username + '\'' +
                ", createdAt='" + this.createdAt + '\'' +
                '}';
    }
}
