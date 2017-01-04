package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.ChannelContainer;

public interface StreamResponseHandler extends BaseFailureHandler {
    /**
     * API callback was successful.
     *
     */
    void onSuccess(ChannelContainer channelContainer);
}
