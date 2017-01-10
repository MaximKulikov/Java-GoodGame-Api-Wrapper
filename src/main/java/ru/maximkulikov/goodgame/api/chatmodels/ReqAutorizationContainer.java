package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqAutorizationContainer implements ChatObject {
    private String type = "auth";
    private ReqAutorization data;

    public ReqAutorizationContainer(int siteId, int userId, String token) {
        this.data = new ReqAutorization(siteId, userId, token);
    }

    public ReqAutorizationContainer(int siteId, int userId) {
        this.data = new ReqAutorization(siteId, userId);
    }

    public ReqAutorization getData() {
        return data;
    }

    public void setData(ReqAutorization data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReqAutorizationContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
