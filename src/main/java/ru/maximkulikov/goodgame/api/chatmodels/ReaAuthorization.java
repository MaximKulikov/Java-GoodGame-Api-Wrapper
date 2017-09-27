package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 08.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ReaAuthorization {

    @JsonProperty("site_id")
    private int siteId;

    @JsonProperty("user_id")
    private int userId;

    private String token;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ReaAuthorization that = (ReaAuthorization) o;

        return new EqualsBuilder()
                .append(siteId, that.siteId)
                .append(userId, that.userId)
                .append(token, that.token)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(siteId)
                .append(userId)
                .append(token)
                .toHashCode();
    }

    /**
     * @param siteId site_id
     * @param userId user_id
     * @param token  token
     */
    ReaAuthorization(final int siteId, final int userId, final String token) {
        this.siteId = siteId;
        this.userId = userId;
        this.token = token;
    }

    /**
     * @param siteId site_id
     * @param userId user_id
     */
    ReaAuthorization(final int siteId, final int userId) {
        this.siteId = siteId;
        this.userId = userId;
    }

    /**
     * @return site_id
     */
    public final int getSiteId() {
        return this.siteId;
    }

    public final void setSiteId(final int siteId) {
        this.siteId = siteId;
    }

    /**
     * @return token
     */
    public final String getToken() {
        return this.token;
    }

    public final void setToken(final String token) {
        this.token = token;
    }

    /**
     * @return user_id
     */
    public final int getUserId() {
        return this.userId;
    }

    public final void setUserId(final int userId) {
        this.userId = userId;
    }

    @Override
    public final String toString() {
        return "AutorizationReq{" +
                "siteId=" + this.siteId +
                ", userId=" + this.userId +
                ", token='" + this.token + '\'' +
                '}';
    }
}
