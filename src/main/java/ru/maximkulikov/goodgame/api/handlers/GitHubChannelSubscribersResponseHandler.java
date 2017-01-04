package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.GitHubSubscribers;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public interface GitHubChannelSubscribersResponseHandler extends BaseFailureHandler {
    void onSuccess(GitHubSubscribers gitHubSubscribers);
}
