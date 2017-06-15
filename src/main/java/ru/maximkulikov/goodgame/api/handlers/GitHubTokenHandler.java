package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.GitHubToken;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.GithubResource}
 *
 * @author Maxim Kulikov
 * @since 20.01.2017
 */
public interface GitHubTokenHandler extends BaseFailureHandler {
    /**
     * @param token Возвращает объект с токенами. Записывает их автоматически в текущий экземпляр
     *              {@link ru.maximkulikov.goodgame.api.GoodGame}
     */
    void onSuccess(GitHubToken token);
}
