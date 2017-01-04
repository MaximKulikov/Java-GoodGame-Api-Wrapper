package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.Player;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
public interface PlayerResponseHandler extends BaseFailureHandler {
    void onSuccess(Player player);
}
