package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.ChannelContainer;

/**
 * Обработчик методор ресурса {@link ru.maximkulikov.goodgame.api.resources.StreamsResource}
 *
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
public interface StreamChannelResponseHandler extends BaseFailureHandler {
    /**
     * @param channel
     */
    void onSuccess(ChannelContainer channel);

}
