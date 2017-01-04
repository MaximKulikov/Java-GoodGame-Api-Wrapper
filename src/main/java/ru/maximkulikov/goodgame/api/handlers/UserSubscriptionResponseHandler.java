package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.UserSubscription;

public interface UserSubscriptionResponseHandler extends BaseFailureHandler {
    void onSuccess(UserSubscription subscription);
}
