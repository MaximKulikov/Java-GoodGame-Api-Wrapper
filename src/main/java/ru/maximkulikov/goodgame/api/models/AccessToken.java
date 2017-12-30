package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Объект с данными Access Token
 *
 * @author Maxim Kulikov
 * @since 29.12.2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {

    @JsonProperty("access_token")
    private String aToken;

    @JsonProperty("expires_in")
    private long expiresIn;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * @return access_token
     */
    @JsonProperty("access_token")
    public final String getAccessToken() {
        return this.aToken;
    }

    @JsonProperty("access_token")
    public final void setAccessToken(final String accessToken) {
        this.aToken = accessToken;
    }

    /**
     * @return expires_in
     */
    @JsonProperty("expires_in")
    public final long getExpiresIn() {
        return this.expiresIn;
    }

    @JsonProperty("expires_in")
    public final void setExpiresIn(final long expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * @return refresh_token
     */
    @JsonProperty("refresh_token")
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @JsonProperty("refresh_token")
    public final void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * @return scope
     */
    @JsonProperty("scope")
    public final String getScope() {
        return this.scope;
    }

    @JsonProperty("scope")
    public final void setScope(final String scope) {
        this.scope = scope;
    }

    /**
     * @return token_type
     */
    @JsonProperty("token_type")
    public final String getTokenType() {
        return this.tokenType;
    }

    @JsonProperty("token_type")
    public final void setTokenType(final String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(aToken)
                .append(expiresIn)
                .append(tokenType)
                .append(scope)
                .append(refreshToken)
                .toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AccessToken that = (AccessToken) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(expiresIn, that.expiresIn)
                .append(aToken, that.aToken)
                .append(tokenType, that.tokenType)
                .append(scope, that.scope)
                .append(refreshToken, that.refreshToken)
                .isEquals();
    }

    @Override
    public final String toString() {
        return "AccessToken{" +
                "accessToken='" + this.aToken + '\'' +
                ", expiresIn=" + this.expiresIn +
                ", tokenType='" + this.tokenType + '\'' +
                ", scope='" + this.scope + '\'' +
                ", refreshToken='" + this.refreshToken + '\'' +
                '}';
    }
}
