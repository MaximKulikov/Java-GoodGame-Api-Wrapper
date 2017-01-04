package ru.maximkulikov.goodgame.api.handlers;

public interface BaseFailureHandler {
    public void onFailure(int statusCode, String statusMessage, String errorMessage);

    public void onFailure(Throwable throwable);
}
