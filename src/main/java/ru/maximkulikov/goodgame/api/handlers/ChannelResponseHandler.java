package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.ChannelContainer;

public interface ChannelResponseHandler extends BaseFailureHandler {
    void onSuccess(ChannelContainer channel);
}
