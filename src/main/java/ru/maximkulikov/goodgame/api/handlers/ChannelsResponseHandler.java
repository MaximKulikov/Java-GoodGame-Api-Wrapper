package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.ChannelContainer;

import java.util.List;

public interface ChannelsResponseHandler extends BaseFailureHandler {
    void onSuccess(int total, List<ChannelContainer> channels);
}
