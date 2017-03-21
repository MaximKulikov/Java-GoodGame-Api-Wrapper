package ru.maximkulikov.goodgame.api.handlers;

public interface BaseFailureHandler {
    void onFailure(int statusCode, String statusMessage, String errorMessage);

    void onFailure(Throwable throwable);
}
