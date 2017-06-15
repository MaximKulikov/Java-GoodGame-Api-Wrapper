package ru.maximkulikov.goodgame.api.handlers;

import java.util.List;
import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.models.AjaxGame;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.AjaxResource}
 *
 * @author Maxim Kulikov
 * @see ru.maximkulikov.goodgame.api.resources.AjaxResource
 * @since 03.04.2017
 */
public interface AjaxGamesHandler extends BaseFailureHandler {
    /**
     * @param ajaxGames Список объектов {@link AjaxGame}
     * @see ru.maximkulikov.goodgame.api.resources.AjaxResource#games(String, AjaxGamesHandler)
     * @see ru.maximkulikov.goodgame.api.resources.AjaxResource#games(String, RequestParams, AjaxGamesHandler)
     */
    void onSuccess(List<AjaxGame> ajaxGames);
}
