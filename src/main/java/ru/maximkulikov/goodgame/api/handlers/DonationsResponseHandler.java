package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.DonationsContainer;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public interface DonationsResponseHandler extends BaseFailureHandler {
    void onSuccess(Long totalItems, DonationsContainer donations);
}
