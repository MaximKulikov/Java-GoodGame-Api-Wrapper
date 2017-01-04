package com.mb3364.twitch.api.handlers;

import com.mb3364.twitch.api.models.ChannelContainer;

public interface ChannelResponseHandler extends BaseFailureHandler {
    void onSuccess(ChannelContainer channel);
}
