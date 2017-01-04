package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.Game;
import ru.maximkulikov.goodgame.api.models.GamesContainer;

import java.util.List;

public interface GamesResponseHandler extends BaseFailureHandler {
    void onSuccess(GamesContainer gamesContainer, List<Game> games);
}
