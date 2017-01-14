package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqAutorizationContainer implements ReqChatObject {

    private String type = "auth";

    private ReqAutorization data;

    public ReqAutorizationContainer(int siteId, int userId, String token) {
        this.data = new ReqAutorization(siteId, userId, token);
    }

    public ReqAutorizationContainer(int siteId, int userId) {
        this.data = new ReqAutorization(siteId, userId);
    }

    public final ReqAutorization getData() {
        return data;
    }

    public final void setData(final ReqAutorization data) {
        this.data = data;
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqAutorizationContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
