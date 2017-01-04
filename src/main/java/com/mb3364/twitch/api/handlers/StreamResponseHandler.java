package com.mb3364.twitch.api.handlers;

import com.mb3364.twitch.api.models.ChannelContainer;

public interface StreamResponseHandler extends BaseFailureHandler {
    /**
     * API callback was successful.
     *
     */
    void onSuccess(ChannelContainer channelContainer);
}
