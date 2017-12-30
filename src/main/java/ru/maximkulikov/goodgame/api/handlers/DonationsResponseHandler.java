package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.DonationsContainer;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.ChannelsResource}
 *
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
public interface DonationsResponseHandler extends BaseFailureHandler {
    /**
     * @param donations экземпляр {@link DonationsContainer}
     */
    void onSuccess(DonationsContainer donations);
}
