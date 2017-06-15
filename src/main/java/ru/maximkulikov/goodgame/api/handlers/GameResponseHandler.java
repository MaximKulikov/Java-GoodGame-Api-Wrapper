package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.Game;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.GamesResource }
 *
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
public interface GameResponseHandler extends BaseFailureHandler {
    /**
     * @param game экземпляр {@link Game}
     */
    void onSuccess(Game game);
}
