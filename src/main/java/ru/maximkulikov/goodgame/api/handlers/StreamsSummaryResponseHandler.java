package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.StreamsSummary;

public interface StreamsSummaryResponseHandler extends BaseFailureHandler {
    void onSuccess(StreamsSummary summary);
}
