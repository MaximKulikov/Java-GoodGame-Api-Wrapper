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

    // Base twitch api url
    private String twitchBaseUrl;

    // The port to listen for the authentication callback on
    private int listenPort;

    private String clientId;

    private URI redirectUri;

    private String state;

    private String accessToken;

    private AccessToken token;

    private AuthenticationError authenticationError;

    public Authenticator(String twitchBaseUrl) {
        this.twitchBaseUrl = twitchBaseUrl;
    }

    public boolean awaitAutorizationCode() {
        // Use default pages
        return awaitAutorizationCode(null, null, null);
    }

    public boolean awaitAutorizationCode(URL authUrl, URL successUrl, URL failUrl) {
        if (clientId == null || redirectUri == null) return false;

        AuthenticationCallbackServer server =
                new AuthenticationCallbackServer(listenPort, authUrl, successUrl, failUrl, state);
        try {
            server.start();
        } catch (IOException e) {
            authenticationError = new AuthenticationError("JavaException", e.toString());
            return false;
        }

        if (server.hasAuthenticationError() || server.getAccessToken() == null) {
            authenticationError = server.getAuthenticationError();
            return false;
        }

        accessToken = server.getAccessToken();
        return true;
    }

    public final AuthenticationError getAuthenticationError() {
        return this.authenticationError;
    }

    public String getAuthenticationUrl(String clientId, URI redirectURI, String state, Scopes... scopes) {
        this.clientId = clientId;
        this.redirectUri = redirectURI;
        this.state = state;

        // Set the listening port for the callback, default to 80 if not specified
        this.listenPort = redirectUri.getPort();
        if (this.listenPort == -1) {
            // HTTP default
            this.listenPort = 80;
        }

        return String.format("%s/oauth/authorize?response_type=code" +
                        "&client_id=%s&redirect_uri=%s&state=%s&scope=%s",
                twitchBaseUrl, clientId, redirectUri, state, Scopes.join(scopes));
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

    public AccessToken getToken() {
        return this.token;
    }

    public boolean hasAccessToken() {
        return accessToken != null;
    }

    public boolean hasAuthenticationError() {
        return authenticationError != null;
    }

    public final void setAccessToken(final AccessToken accessToken) {
        this.token = accessToken;
    }

    public final void setAccessTokenHeader(final String accessToken) {
        this.accessToken = accessToken;
    }

}
