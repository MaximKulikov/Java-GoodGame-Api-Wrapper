package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.UpdateTitle;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 02.04.2017.
 */
public interface UpdateTitleResponseHandler extends BaseFailureHandler {
    void onSuccess(UpdateTitle updateTitle);
}
