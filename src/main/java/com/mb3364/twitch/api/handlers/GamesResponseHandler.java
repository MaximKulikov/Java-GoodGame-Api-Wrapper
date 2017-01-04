package com.mb3364.twitch.api.handlers;

import com.mb3364.twitch.api.models.Game;
import com.mb3364.twitch.api.models.GamesContainer;

import java.util.List;

public interface GamesResponseHandler extends BaseFailureHandler {
    void onSuccess(GamesContainer gamesContainer, List<Game> games);
}
