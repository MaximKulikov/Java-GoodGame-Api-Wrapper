package ru.maximkulikov.goodgame.api.handlers;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.GithubResource}
 *
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
public interface GitHubSharedHandler extends BaseFailureHandler {
    /**
     * @param content Возвращает Строку ответа в том виде, в котором ее отдает сервис. Формат ответа JSON
     */
    void onSuccess(String content);
}
