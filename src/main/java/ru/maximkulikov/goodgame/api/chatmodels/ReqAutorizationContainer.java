package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqAutorizationContainer implements ReqChatObject {

    private String type = "auth";

    private ReaAuthorization data;

    public ReqAutorizationContainer(final int siteId, final int userId, final String token) {
        this.data = new ReaAuthorization(siteId, userId, token);
    }

    public ReqAutorizationContainer(final int siteId, final int userId) {
        this.data = new ReaAuthorization(siteId, userId);
    }

    public final ReaAuthorization getData() {
        return this.data;
    }

    public final void setData(final ReaAuthorization data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqAutorizationContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
