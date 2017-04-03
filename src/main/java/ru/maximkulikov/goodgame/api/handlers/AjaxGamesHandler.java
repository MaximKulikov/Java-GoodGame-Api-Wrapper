package ru.maximkulikov.goodgame.api.handlers;

import java.util.List;
import ru.maximkulikov.goodgame.api.models.AjaxGame;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 03.04.2017.
 */

public interface AjaxGamesHandler extends BaseFailureHandler {
    void onSuccess(List<AjaxGame> ajaxGames);
}
