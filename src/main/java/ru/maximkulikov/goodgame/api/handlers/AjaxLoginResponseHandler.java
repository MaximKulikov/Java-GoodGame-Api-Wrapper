package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.AjaxLoginContainer;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.AjaxResource}
 *
 * @author Maxim Kulikov
 * @see ru.maximkulikov.goodgame.api.resources.AjaxResource#login(String, String, AjaxLoginResponseHandler)
 * @since 03.04.2017
 */
public interface AjaxLoginResponseHandler extends BaseFailureHandler {
    /**
     * Дополнительно включена PHP сессия, при получении сессия также прописывается в объект GoodGame
     * @param ajaxLoginContainer экземпляр {@link AjaxLoginContainer}
     */
    void onSuccess(AjaxLoginContainer ajaxLoginContainer);
}
