package ru.maximkulikov.goodgame.api.handlers;


import ru.maximkulikov.goodgame.api.models.OauthResourceCheck;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public interface OauthResourceResponseHandler extends BaseFailureHandler {
    void onSuccess(OauthResourceCheck resource);
}
