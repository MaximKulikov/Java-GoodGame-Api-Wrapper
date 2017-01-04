package com.mb3364.twitch.api.handlers;

import com.mb3364.twitch.api.models.AccessToken;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
public interface OauthResponseHandler extends BaseFailureHandler {
    void onSuccess(AccessToken accessToken);
}
