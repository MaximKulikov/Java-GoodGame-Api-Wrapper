package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.UpdateTitle;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.AjaxResource}
 *
 * @author Maxim Kulikov
 * @since 02.04.2017
 */
public interface UpdateTitleResponseHandler extends BaseFailureHandler {
    /**
     * @param updateTitle
     */
    void onSuccess(UpdateTitle updateTitle);
}
