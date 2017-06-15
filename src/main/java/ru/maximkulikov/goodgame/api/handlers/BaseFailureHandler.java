package ru.maximkulikov.goodgame.api.handlers;

/**
 * Обработчик неуспешных ответов
 */
public interface BaseFailureHandler {
    /**
     * @param statusCode    Код ответа
     * @param statusMessage Сообщение с ошибкой
     * @param errorMessage  Детальное опсиание ошибки
     */
    void onFailure(int statusCode, String statusMessage, String errorMessage);

    /**
     * @param throwable Эксепшен в процессе общения с сервером
     */
    void onFailure(Throwable throwable);
}
