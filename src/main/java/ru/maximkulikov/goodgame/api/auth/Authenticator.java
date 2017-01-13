package ru.maximkulikov.goodgame.api.auth;

import ru.maximkulikov.goodgame.api.auth.grants.implicit.AuthenticationCallbackServer;
import ru.maximkulikov.goodgame.api.auth.grants.implicit.AuthenticationError;
import ru.maximkulikov.goodgame.api.models.AccessToken;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * The authenticator object allows a user to authenticate with the Twitch.tv servers.
 *
 * @author Matthew Bell
 */
public class Authenticator {

    private String twitchBaseUrl; // Base twitch api url
    private int listenPort; // The port to listen for the authentication callback on
    private String clientId;
    private URI redirectUri;
    private String state;

    private String accessToken;
    private AccessToken token;
    private AuthenticationError authenticationError;

    public AccessToken getToken() {
        return token;
    }

    public Authenticator(String twitchBaseUrl) {
        this.twitchBaseUrl = twitchBaseUrl;
    }

     public String getAuthenticationUrl(String clientId, URI redirectURI, String state, Scopes... scopes ) {
        this.clientId = clientId;
        this.redirectUri = redirectURI;
        this.state = state;

        // Set the listening port for the callback, default to 80 if not specified
        this.listenPort = redirectUri.getPort();
        if (this.listenPort == -1) {
            this.listenPort = 80; // HTTP default
        }

        return String.format("%s/oauth/authorize?response_type=code" +
                        "&client_id=%s&redirect_uri=%s&state=%s&scope=%s",
                twitchBaseUrl, clientId, redirectUri, state, Scopes.join(scopes));
    }


    public boolean awaitAutorizationCode() {
        return awaitAutorizationCode(null, null, null); // Use default pages
    }

      public boolean awaitAutorizationCode(URL authUrl, URL successUrl, URL failUrl) {
        if (clientId == null || redirectUri == null) return false;

        AuthenticationCallbackServer server = new AuthenticationCallbackServer(listenPort, authUrl, successUrl, failUrl, state);
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

    public String getClientId() {
        return clientId;
    }

    public URI getRedirectUri() {
        return redirectUri;
    }

    public String getAutorizationCode() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.token = accessToken;
    }

    public void setAccessTokenHeader(String accessToken) {
        this.accessToken = accessToken;
    }


    public boolean hasAccessToken() {
        return accessToken != null;
    }


    public AuthenticationError getAuthenticationError() {
        return authenticationError;
    }


    public boolean hasAuthenticationError() {
        return authenticationError != null;
    }

}
