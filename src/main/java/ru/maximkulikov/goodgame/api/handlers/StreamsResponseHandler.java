package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.EmbededChannels;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.StreamsResource}
 *
 * @author Maxim Kulikov
 * @since 18.01.2017
 */
public interface StreamsResponseHandler extends BaseFailureHandler {
    /**
     * @param channels
     */
    void onSuccess(EmbededChannels channels);
}
