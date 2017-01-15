package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private long expiresIn;

    @JsonProperty("token_type")
    private String tokenType;

    private String scope;

    @JsonProperty("refresh_token")
    private String refreshToken;


    public final String getAccessToken() {
        return accessToken;
    }

    public final void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    public final long getExpiresIn() {
        return expiresIn;
    }

    public final void setExpiresIn(final long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public final String getRefreshToken() {
        return refreshToken;
    }

    public final void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public final String getScope() {
        return scope;
    }

    public final void setScope(final String scope) {
        this.scope = scope;
    }

    public final String getTokenType() {
        return tokenType;
    }

    public final void setTokenType(final String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public final String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", tokenType='" + tokenType + '\'' +
                ", scope='" + scope + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }
}
