package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.PremiumsContainer;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.ChannelsResource}
 *
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
public interface PremiumsResponseHandler extends BaseFailureHandler {
    /**
     * @param premiums
     */
    void onSuccess(PremiumsContainer premiums);
}
