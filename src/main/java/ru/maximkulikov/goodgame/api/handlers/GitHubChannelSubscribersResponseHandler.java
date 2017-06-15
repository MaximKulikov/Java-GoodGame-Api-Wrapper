package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.GitHubSubscribers;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.GithubResource}
 *
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
public interface GitHubChannelSubscribersResponseHandler extends BaseFailureHandler {
    /**
     * @param gitHubSubscribers экземпляр {@link GitHubSubscribers}
     */
    void onSuccess(GitHubSubscribers gitHubSubscribers);
}
