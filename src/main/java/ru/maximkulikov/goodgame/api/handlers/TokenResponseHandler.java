package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.Token;

public interface TokenResponseHandler extends BaseFailureHandler {
    void onSuccess(Token token);
}
