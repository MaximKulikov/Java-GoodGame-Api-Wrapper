package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 20.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubToken {

    private Boolean success;

    private String scope;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public final String getScope() {
        return this.scope;
    }

    public final void setScope(final String scope) {
        this.scope = scope;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(final Boolean success) {
        this.success = success;
    }

    @Override
    public final String toString() {
        return "GitHubToken{" +
                "success=" + this.success +
                ", scope='" + this.scope + '\'' +
                ", accessToken='" + this.accessToken + '\'' +
                ", refreshToken='" + this.refreshToken + '\'' +
                '}';
    }
}
