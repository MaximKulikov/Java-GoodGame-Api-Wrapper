package ru.maximkulikov.goodgame.api.auth;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import ru.maximkulikov.goodgame.api.auth.grants.implicit.AuthenticationCallbackServer;
import ru.maximkulikov.goodgame.api.auth.grants.implicit.AuthenticationError;

/**
 * The authenticator object allows a user to authenticate with the Twitch.tv servers.
 *
 * @author Matthew Bell
 */
public class Authenticator {

    private static final int DEFAULT_HTTP_PORT = 80;

    // Base twitch api url
    private String goodgameBaseUrl;

    // The port to listen for the authentication callback on
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

    public final boolean awaitAutorizationCode() {
        // Use default pages
        return this.awaitAutorizationCode(null, null, null);
    }

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

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    public final AuthenticationError getAuthenticationError() {
        return this.authenticationError;
    }

    public final String getAuthenticationUrl(final String clientId, final URI redirectURI,
                                             final String state, final Scopes... scopes) {
        this.clientId = clientId;
        this.redirectUri = redirectURI;
        this.state = state;

        // Set the listening port for the callback, default to 80 if not specified
        this.listenPort = this.redirectUri.getPort();
        if (this.listenPort == -1) {
            // HTTP default
            this.listenPort = DEFAULT_HTTP_PORT;
        }

        return String.format("%s/oauth/authorize?response_type=code" +
                        "&client_id=%s&redirect_uri=%s&state=%s&scope=%s",
                this.goodgameBaseUrl, this.clientId, this.redirectUri, this.state, Scopes.join(scopes));
    }

    public final String getAutorizationCode() {
        return this.authentificationCode;
    }

    @Deprecated
    public final String getClientId() {
        return this.clientId;
    }

    public final URI getRedirectUri() {
        return this.redirectUri;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public final String getState() {
        return this.state;
    }

    public final boolean hasAuthenticationError() {
        return this.authenticationError != null;
    }

    public final boolean hasAuthentificationCode() {
        return this.authentificationCode != null;
    }
}
