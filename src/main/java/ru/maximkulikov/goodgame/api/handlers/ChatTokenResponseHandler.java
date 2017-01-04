package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.ChatToken;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public interface ChatTokenResponseHandler extends BaseFailureHandler {
    void onSuccess(ChatToken chatToken);
}
