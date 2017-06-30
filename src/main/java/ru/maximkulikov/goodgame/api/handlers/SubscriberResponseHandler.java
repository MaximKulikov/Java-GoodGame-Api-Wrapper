package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.SubscrurersContainer;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.ChannelsResource}
 *
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
public interface SubscriberResponseHandler extends BaseFailureHandler {
    /**
     * @param subscribers
     */
    void onSuccess(SubscrurersContainer subscribers);
}
