package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.Info;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.InfoResource}
 *
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
public interface InfoResponseHandler extends BaseFailureHandler {
    /**
     * @param info Информация по текущему Access токену
     */
    void onSuccess(Info info);
}
