package ru.maximkulikov.goodgame.api.handlers;

import java.util.List;
import ru.maximkulikov.goodgame.api.models.Stream;

public interface StreamsResponseHandler extends BaseFailureHandler {
    void onSuccess(int total, List<Stream> streams);
}
