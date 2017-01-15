package ru.maximkulikov.goodgame.api.auth;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import ru.maximkulikov.goodgame.api.auth.grants.implicit.AuthenticationCallbackServer;
import ru.maximkulikov.goodgame.api.auth.grants.implicit.AuthenticationError;
import ru.maximkulikov.goodgame.api.models.AccessToken;

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

    private String clientId;

    private URI redirectUri;

    private String state;

    private String accessToken;

    private AccessToken token;

    private AuthenticationError authenticationError;

    public Authenticator(final String goodgameBaseUrl) {
        this.goodgameBaseUrl = goodgameBaseUrl;
    }

    public final boolean awaitAutorizationCode() {
        // Use default pages
        return this.awaitAutorizationCode(null, null, null);
    }

    public final boolean awaitAutorizationCode(final URL authUrl, URL successUrl, URL failUrl) {
        if (this.clientId == null || this.redirectUri == null) {
            return false;
        }

        AuthenticationCallbackServer server =
                new AuthenticationCallbackServer(this.listenPort, authUrl, successUrl, failUrl, state);
        try {
            server.start();
        } catch (IOException e) {
            this.authenticationError = new AuthenticationError("JavaException", e.toString());
            return false;
        }

        if (server.hasAuthenticationError() || server.getAccessToken() == null) {
            this.authenticationError = server.getAuthenticationError();
            return false;
        }

        this.accessToken = server.getAccessToken();
        return true;
    }

    public final AuthenticationError getAuthenticationError() {
        return this.authenticationError;
    }

    public String getAuthenticationUrl(final String clientId, URI redirectURI, String state, Scopes... scopes) {
        this.clientId = clientId;
        this.redirectUri = redirectURI;
        this.state = state;

        // Set the listening port for the callback, default to 80 if not specified
        this.listenPort = redirectUri.getPort();
        if (this.listenPort == -1) {
            // HTTP default
            this.listenPort = DEFAULT_HTTP_PORT;
        }

        return String.format("%s/oauth/authorize?response_type=code" +
                        "&client_id=%s&redirect_uri=%s&state=%s&scope=%s",
                this.goodgameBaseUrl, clientId, this.redirectUri, state, Scopes.join(scopes));
    }

    public final String getAutorizationCode() {
        return this.accessToken;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final URI getRedirectUri() {
        return this.redirectUri;
    }

    public final AccessToken getToken() {
        return this.token;
    }

    public final boolean hasAccessToken() {
        return this.accessToken != null;
    }

    public final boolean hasAuthenticationError() {
        return this.authenticationError != null;
    }

    public final void setAccessToken(final AccessToken accessToken) {
        this.token = accessToken;
    }

    public final void setAccessTokenHeader(final String accessToken) {
        this.accessToken = accessToken;
    }

}
