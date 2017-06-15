package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.AccessToken;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.OauthResource}
 *
 * @author Maxim Kulikov
 * @since 29.12.2016
 */
public interface OauthResponseHandler extends BaseFailureHandler {
    /**
     * @param accessToken Получение токенов. Автоматически происходит установка полученных токенов: <br>
     *                    {@link ru.maximkulikov.goodgame.api.auth.Authenticator#setAccessToken(String)},<br>
     *                    {@link ru.maximkulikov.goodgame.api.auth.Authenticator#setRefreshToken(String)}
     */
    void onSuccess(AccessToken accessToken);
}
