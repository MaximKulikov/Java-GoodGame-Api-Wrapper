package ru.maximkulikov.goodgame.api.auth.grants.implicit;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;

public class AuthenticationCallbackServer implements AuthenticationListener {

    /**
     * Default HTML page that twitch.tv will send the access_token to
     */
    public static final String DEFAULT_AUTH_PAGE = "/gg-authorize.html";

    /**
     * Default HTML page that shows auth error's to user
     */
    public static final String DEFAULT_FAILURE_PAGE = "/gg-authorize-failure.html";

    /**
     * Default HTML page that shows auth success to
     */
    public static final String DEFAULT_SUCCESS_PAGE = "/gg-authorize-success.html";

    private final URL authPage;

    private final URL failurePage;

    private final URL successPage;

    private int port;

    private ServerSocket serverSocket;

    private String accessToken;

    private AuthenticationError authenticationError;

    private String stateRequest;

    private String stateAnswer;


    public AuthenticationCallbackServer(int port) {
        this.port = port;
        // Load default pages
        authPage = getClass().getResource(this.DEFAULT_AUTH_PAGE);
        failurePage = getClass().getResource(this.DEFAULT_FAILURE_PAGE);
        successPage = getClass().getResource(this.DEFAULT_SUCCESS_PAGE);
    }


    public AuthenticationCallbackServer(int port, URL authPage, URL failurePage, URL successPage, String stateRequest) {
        this.port = port;
        this.authPage = authPage == null ? getClass().getResource(this.DEFAULT_AUTH_PAGE) : authPage;
        this.failurePage = failurePage == null ? getClass().getResource(this.DEFAULT_FAILURE_PAGE) : failurePage;
        this.successPage = successPage == null ? getClass().getResource(this.DEFAULT_SUCCESS_PAGE) : successPage;
        this.stateRequest = stateRequest;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final AuthenticationError getAuthenticationError() {
        return this.authenticationError;
    }

    public final String getStateAnswer() {
        return this.stateAnswer;
    }

    public final boolean hasAuthenticationError() {
        return authenticationError != null;
    }

    public boolean isRunning() {
        return serverSocket != null;
    }

    @Override
    public void onAccessTokenReceived(String token, String state) {

        if (token != null && state.equals(stateRequest)) {
            this.accessToken = token;
        }
        // Stop the server, we no longer need to process requests
        stop();
    }

    @Override
    public void onAuthenticationError(String error, String description) {
        this.authenticationError = new AuthenticationError(error, description);
        // Stop the server
        stop();
    }

    private void run() throws IOException {
        // Process HTTP service requests
        while (true) {
            try {
                // Listen for a TCP connection request
                Socket connectionSocket = serverSocket.accept();
                // Handle request
                AuthenticationCallbackRequest request =
                        new AuthenticationCallbackRequest(connectionSocket, authPage, failurePage, successPage);
                request.setAuthenticationListener(this);
                // Start thread
                Thread thread = new Thread(request);
                thread.start();
            } catch (SocketException e) {
                // Socket was closed by another thread
                break;
            }
        }
    }

    public void start() throws IOException {
        // Establish the listen socket
        // For security reasons, the third parameter is set to not accept connections from outside the localhost
        this.serverSocket = new ServerSocket(port, 0, InetAddress.getByName("127.0.0.1"));
        run();
    }

    /**
     * Stops the server.
     */
    public final void stop() {
        if (serverSocket != null && !serverSocket.isClosed()) {
            try {
                this.serverSocket.close();
            } catch (IOException ignored) {
            } finally {
                this.serverSocket = null;
            }
        }
    }
}
