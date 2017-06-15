package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.GoodChat;
import ru.maximkulikov.goodgame.api.models.ChatToken;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.ChatResource}
 *
 * @autor Maxim Kulikov
 * @since 04.01.2017
 */
public interface ChatTokenResponseHandler extends BaseFailureHandler {
    /**
     * @param chatToken Токен для чата
     * @see GoodChat#connect()
     * @see ru.maximkulikov.goodgame.api.chatmodels.ReqAutorizationContainer
     */
    void onSuccess(ChatToken chatToken);
}
