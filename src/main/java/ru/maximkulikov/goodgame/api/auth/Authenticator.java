package ru.maximkulikov.goodgame.api.auth;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import ru.maximkulikov.goodgame.api.auth.grants.implicit.AuthenticationCallbackServer;
import ru.maximkulikov.goodgame.api.auth.grants.implicit.AuthenticationError;

/**
 * Объект {@link Authenticator} позволяет получить авторизационный каод для последующей авторизации на сервера Goodgame.ru.
 *
 * @author Matthew Bell
 * @author Maxim Kulikov
 */
public class Authenticator {

    private static final int DEFAULT_HTTP_PORT = 80;

    private String goodgameBaseUrl;

    private int listenPort;

    //TODO Убрать эту переменную, заменить на gg.getCliendID
    private String clientId;

    private URI redirectUri;

    private String state;

    private String authentificationCode;

    private String accessToken;

    private String refreshToken;

    private AuthenticationError authenticationError;

    public Authenticator(final String goodgameBaseUrl) {
        this.goodgameBaseUrl = goodgameBaseUrl;
    }

    /**
     * Использование стандартные страниц ответа
     *
     * @return Возвращает <i>true</i> при успешном прохождении всех шагов получения авторизационного кода
     */
    public final boolean awaitAutorizationCode() {

        return this.awaitAutorizationCode(null, null, null);
    }

    /**
     * Использование собственных страниц на ответ авторизации
     *
     * @param authUrl    Страница первоначальное переадрессации
     * @param successUrl Страница об успешном получение авторизационного кода
     * @param failUrl    Страница о неудачном получении авторизациннного кода
     * @return Возвращает <i>true</i> при успешном прохождении всех шагов получения авторизационного кода
     */
    public final boolean awaitAutorizationCode(final URL authUrl, final URL successUrl, final URL failUrl) {
        if (this.clientId == null || this.redirectUri == null) {
            return false;
        }

        AuthenticationCallbackServer server =
                new AuthenticationCallbackServer(this.listenPort, authUrl, successUrl, failUrl, this.state);
        try {
            server.start();
        } catch (IOException e) {
            this.authenticationError = new AuthenticationError("JavaException", e.toString());
            return false;
        }

        if (server.hasAuthenticationError() || server.getAuthentificationCode() == null) {
            this.authenticationError = server.getAuthenticationError();
            return false;
        }

        this.authentificationCode = server.getAuthentificationCode();
        return true;
    }

    /**
     * @return Access Token
     */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /**
     * @param accessToken Access Token
     */
    public final void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;

    }

    /**
     * @return
     */
    public final AuthenticationError getAuthenticationError() {
        return this.authenticationError;
    }

    /**
     * @return Авторизационный код
     */
    public final String getAutorizationCode() {
        return this.authentificationCode;
    }

    @Deprecated
    public final String getClientId() {
        return this.clientId;
    }

    /**
     * @return Ссылка для перехода на страницу авторизации (возможно)
     */
    public final URI getRedirectUri() {
        return this.redirectUri;
    }

    /**
     * @return Refresh Token
     */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /**
     * Метод выполняется автоматически, при авторизации.
     *
     * @param refreshToken Refresh Token
     */
    public final void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
