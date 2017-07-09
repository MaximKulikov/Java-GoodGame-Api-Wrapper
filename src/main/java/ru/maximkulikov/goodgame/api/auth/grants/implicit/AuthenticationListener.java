package ru.maximkulikov.goodgame.api.auth.grants.implicit;

/**
 * Interface for listening  authentication
 * access tokens
 *
 * @author Matthew Bell
 */
public interface AuthenticationListener {
    /**
     * Called when a authentication access token has been received.
     *
     * @param token authentication access token
     */
    void onAccessTokenReceived(String token, String state);

    /**
     * An authentication error occurred.
     * Usually due to user denying the request.
     *
     * @param error       Error name
     * @param description Error description
     */
    void onAuthenticationError(String error, String description);
}
