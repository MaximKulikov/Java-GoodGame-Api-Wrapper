package ru.maximkulikov.goodgame.api.handlers;

import java.util.List;
import ru.maximkulikov.goodgame.api.models.ChannelContainer;

public interface ChannelsResponseHandler extends BaseFailureHandler {
    void onSuccess(int total, List<ChannelContainer> channels);
}
