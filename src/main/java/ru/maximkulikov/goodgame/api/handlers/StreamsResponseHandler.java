package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.Stream;

import java.util.List;

public interface StreamsResponseHandler extends BaseFailureHandler {
    void onSuccess(int total, List<Stream> streams);
}
