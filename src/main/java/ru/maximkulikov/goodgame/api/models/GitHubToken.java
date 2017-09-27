package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 20.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubToken {

    private Boolean success;

    private String scope;

    @JsonProperty("access_token")
    private String accessToken;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GitHubToken that = (GitHubToken) o;

        return new EqualsBuilder()
                .append(success, that.success)
                .append(scope, that.scope)
                .append(accessToken, that.accessToken)
                .append(refreshToken, that.refreshToken)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(success)
                .append(scope)
                .append(accessToken)
                .append(refreshToken)
                .toHashCode();
    }

    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * @return access_token
     */
    public final String getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return refresh_token
     */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * @return scope
     */
    public final String getScope() {
        return this.scope;
    }

    public final void setScope(final String scope) {
        this.scope = scope;
    }

    /**
     * @return success
     */
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
