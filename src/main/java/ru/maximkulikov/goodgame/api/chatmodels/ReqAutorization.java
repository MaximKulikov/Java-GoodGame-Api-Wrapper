package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ReqAutorization {

    @JsonProperty("site_id")
    private int siteId;

    @JsonProperty("user_id")
    private int userId;

    private String token;

    public ReqAutorization(int siteId, int userId, String token) {
        this.siteId = siteId;
        this.userId = userId;
        this.token = token;
    }

    public ReqAutorization(int siteId, int userId) {
        this.siteId = siteId;
        this.userId = userId;
    }

    public final int getSiteId() {
        return siteId;
    }

    public final void setSiteId(final int siteId) {
        this.siteId = siteId;
    }

    public final String getToken() {
        return token;
    }

    public final void setToken(final String token) {
        this.token = token;
    }

    public final int getUserId() {
        return userId;
    }

    public final void setUserId(final int userId) {
        this.userId = userId;
    }

    @Override
    public final String toString() {
        return "AutorizationReq{" +
                "siteId=" + siteId +
                ", userId=" + userId +
                ", token='" + token + '\'' +
                '}';
    }
}
