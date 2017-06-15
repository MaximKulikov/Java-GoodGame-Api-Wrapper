package ru.maximkulikov.goodgame.api.handlers;


import ru.maximkulikov.goodgame.api.models.OauthResourceCheck;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.OauthResource}
 *
 * @since 04.01.2017
 * @author Maxim Kulikov
 */
public interface OauthResourceResponseHandler extends BaseFailureHandler {
    /**
     *
     * @param resource Проверка возможности использования API Goodgame от лица пользователя
     */
    void onSuccess(OauthResourceCheck resource);
}
