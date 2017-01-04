package com.mb3364.twitch.api.handlers;

import com.mb3364.twitch.api.models.SubscrurersContainer;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 03.01.2017.
 */
public interface SubscriberResponseHandler extends BaseFailureHandler {
    void onSuccess(SubscrurersContainer subscribers);
}
