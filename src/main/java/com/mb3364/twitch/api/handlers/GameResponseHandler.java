package com.mb3364.twitch.api.handlers;

import com.mb3364.twitch.api.models.Game;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public interface GameResponseHandler extends BaseFailureHandler {
    void onSuccess(Game game);
}
