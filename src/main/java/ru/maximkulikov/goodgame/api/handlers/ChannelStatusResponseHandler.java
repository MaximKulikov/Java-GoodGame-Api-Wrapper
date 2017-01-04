package ru.maximkulikov.goodgame.api.handlers;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public interface ChannelStatusResponseHandler extends BaseFailureHandler {
    void onSuccess(String content);
}
