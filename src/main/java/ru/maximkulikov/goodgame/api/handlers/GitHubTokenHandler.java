package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.GitHubToken;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 20.01.2017.
 */
public interface GitHubTokenHandler extends BaseFailureHandler {
    void onSuccess(GitHubToken token);
}
