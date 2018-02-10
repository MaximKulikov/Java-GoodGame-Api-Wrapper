package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqAutorizationContainer implements ReqChatObject {

    private String type = "auth";

    private ReqAuthorization data;

    public ReqAutorizationContainer(final int siteId, final int userId, final String token) {
        this.data = new ReqAuthorization(siteId, userId, token);
    }

}
