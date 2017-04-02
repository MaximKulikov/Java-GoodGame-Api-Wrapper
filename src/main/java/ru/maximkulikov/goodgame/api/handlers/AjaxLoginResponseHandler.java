package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.AjaxLoginContainer;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 03.04.2017.
 */
public interface AjaxLoginResponseHandler extends BaseFailureHandler {
    void onSuccess(AjaxLoginContainer ajaxLoginContainer, String session);
}
