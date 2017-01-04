package com.mb3364.twitch.api.handlers;

import com.mb3364.twitch.api.models.DonationsContainer;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public interface DonationsResponseHandler extends BaseFailureHandler {
    void onSuccess(DonationsContainer donations);
}
