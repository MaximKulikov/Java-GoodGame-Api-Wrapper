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
    private int siteId;  // идентификатор сайта (обязательно) - передается один раз, при авторизации.
    @JsonProperty("user_id")
    private int userId;       // идентификатор пользователя на сайте, либо 0 для гостей
    private String token; // ключ авторизации. Если не указан, то будет запрошен гостевой доступ.

    public ReqAutorization(int siteId, int userId, String token) {
        this.siteId = siteId;
        this.userId = userId;
        this.token = token;
    }

    public ReqAutorization(int siteId, int userId) {
        this.siteId = siteId;
        this.userId = userId;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AutorizationReq{" +
                "siteId=" + siteId +
                ", userId=" + userId +
                ", token='" + token + '\'' +
                '}';
    }
}
