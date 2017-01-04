package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.PremiumsContainer;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 03.01.2017.
 */
public interface PremiumsResponseHandler  extends BaseFailureHandler
{
    void onSuccess(PremiumsContainer premiums);
}
