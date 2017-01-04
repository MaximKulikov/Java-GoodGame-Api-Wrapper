package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.Info;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public interface InfoResponseHandler extends BaseFailureHandler {
    void onSuccess(Info info);
}
