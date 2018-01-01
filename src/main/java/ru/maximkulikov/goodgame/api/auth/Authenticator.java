package ru.maximkulikov.goodgame.api.auth;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.GoodGame;
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
    private static final Logger logger = LoggerFactory.getLogger(Authenticator.class);
    private String goodgameBaseUrl;
    private int listenPort;
    private String host;
    private GoodGame gg;
    private String authentificationCode;
    private String accessToken;
    private String refreshToken;
    private AuthenticationError authenticationError;
    private URI redirectURI;

    public Authenticator(final String goodgameBaseUrl, final GoodGame gg) {
        this.goodgameBaseUrl = goodgameBaseUrl;
        this.gg = gg;
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


        AuthenticationCallbackServer server =
                new AuthenticationCallbackServer(this.listenPort, this.host, authUrl, successUrl, failUrl, this.gg.getState());
        try {
            server.start();
        } catch (IOException e) {
            logger.error("Java Exception: {}", e.getLocalizedMessage());
            this.authenticationError = new AuthenticationError("JavaException", e.toString());
            return false;
        }

        if (server.hasAuthenticationError() || server.getAuthentificationCode() == null) {
            logger.error("Authentication Code Error");
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
     * @param redirectURI
     * @param scopes
     * @return Ссылка для отправки пользователей на авторизацию
     */
    public final String getAuthenticationUrl(final URI redirectURI, final Scopes... scopes) {

        String state = this.gg.getState();
        String clientId = this.gg.getClientId();
        this.redirectURI = redirectURI;

        if (state == null || clientId == null || redirectURI == null) {
            logger.error("Something null: state = {}, clienr ID = {}, URI = {}", state, clientId, redirectURI);
            return null;
        }

        // Set the listening port for the callback, default to 80 if not specified
        this.listenPort = redirectURI.getPort();
        if (this.listenPort == -1) {
            // HTTP default
            this.listenPort = DEFAULT_HTTP_PORT;
        }

        return String.format("%s/oauth/authorize?response_type=code" +
                        "&client_id=%s&redirect_uri=%s&state=%s&scope=%s",
                this.goodgameBaseUrl, clientId, redirectURI, state, Scopes.join(scopes));
    }

    /**
     * @return Авторизационный код
     */
    public final String getAuthorizationCode() {
        return this.authentificationCode;
    }

    public URI getRedirectURI() {
        return redirectURI;
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

    /**
     * @param host Изменяет стантартный адрес 127.0.0.1 на который придет ответ от GoodGame.
     * @return
     */
    public String setHost(final String host) {
        return this.host = host;

    }
}
