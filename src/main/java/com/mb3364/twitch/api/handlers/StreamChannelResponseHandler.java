package com.mb3364.twitch.api.handlers;

import com.mb3364.twitch.api.models.ChannelContainer;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 03.01.2017.
 */
public interface StreamChannelResponseHandler extends BaseFailureHandler {

        void onSuccess(ChannelContainer channel);

}
