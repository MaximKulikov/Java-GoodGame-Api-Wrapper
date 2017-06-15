package ru.maximkulikov.goodgame.api.handlers;

import java.util.List;
import ru.maximkulikov.goodgame.api.models.Game;
import ru.maximkulikov.goodgame.api.models.GamesContainer;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.GamesResource}
 *
 * @author Maxim Kulikov
 */
public interface GamesResponseHandler extends BaseFailureHandler {
    /**
     * Метод возвращает контейнер со всеми данными и отдельно список с играми из этого контейнера. Вывод постраничный.
     *
     * @param gamesContainer экземпляр {@link GamesContainer}
     * @param games          Список {@link Game} из контейнера {@link GamesContainer}.
     */
    void onSuccess(GamesContainer gamesContainer, List<Game> games);
}
