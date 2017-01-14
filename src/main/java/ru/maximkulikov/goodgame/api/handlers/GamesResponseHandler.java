package ru.maximkulikov.goodgame.api.handlers;

import java.util.List;
import ru.maximkulikov.goodgame.api.models.Game;
import ru.maximkulikov.goodgame.api.models.GamesContainer;

public interface GamesResponseHandler extends BaseFailureHandler {
    void onSuccess(GamesContainer gamesContainer, List<Game> games);
}
