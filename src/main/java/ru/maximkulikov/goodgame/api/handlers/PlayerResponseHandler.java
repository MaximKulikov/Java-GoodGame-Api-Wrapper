package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.Player;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.PlayerResourses}
 *
 * @author Maxim Kulikov
 * @since 29.12.20016
 */
public interface PlayerResponseHandler extends BaseFailureHandler {
    /**
     * @param player ВОзвращает объект {@link Player}
     */
    void onSuccess(Player player);
}
