package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.ChannelContainer;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 03.01.2017.
 */
public interface StreamChannelResponseHandler extends BaseFailureHandler {

        void onSuccess(ChannelContainer channel);

}
