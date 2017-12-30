package ru.maximkulikov.goodgame.api.auth.grants.implicit;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.Date;

/**
 * @author Matthew Bell
 */
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

    private String host = "127.0.0.1";

    private ServerSocket serverSocket;

    private String accessToken;

    private AuthenticationError authenticationError;

    private String stateRequest;

    private String stateAnswer;


    public AuthenticationCallbackServer(final int port) {
        this.port = port;
        // Load default pages
        this.authPage = getClass().getResource(DEFAULT_AUTH_PAGE);
        this.failurePage = getClass().getResource(DEFAULT_FAILURE_PAGE);
        this.successPage = getClass().getResource(DEFAULT_SUCCESS_PAGE);
    }


    public AuthenticationCallbackServer(final int port, final String host, final URL authPage, final URL failurePage,
                                        final URL successPage, final String stateRequest) {
        this.port = port;
        this.host = host;
        this.authPage = authPage == null ? getClass().getResource(DEFAULT_AUTH_PAGE) : authPage;
        this.failurePage = failurePage == null ? getClass().getResource(DEFAULT_FAILURE_PAGE) : failurePage;
        this.successPage = successPage == null ? getClass().getResource(DEFAULT_SUCCESS_PAGE) : successPage;
        this.stateRequest = stateRequest;
    }

    public final AuthenticationError getAuthenticationError() {
        return this.authenticationError;
    }

    public final String getAuthentificationCode() {
        return this.accessToken;
    }

    public final String getStateAnswer() {
        return this.stateAnswer;
    }

    public final boolean hasAuthenticationError() {
        return this.authenticationError != null;
    }

    public final boolean isRunning() {
        return this.serverSocket != null;
    }

    @Override
    public void onAccessTokenReceived(final String token, final String state) {

        if (token != null && state.equals(this.stateRequest)) {
            this.accessToken = token;
        }
        // Stop the server, we no longer need to process requests
        this.stop();
    }

    @Override
    public void onAuthenticationError(final String error, final String description) {
        this.authenticationError = new AuthenticationError(error, description);
        // Stop the server
        this.stop();
    }

    private void run() throws IOException {
        // Process HTTP service requests
        // 5 min
        int timeout = 5 * 60 * 1000;
        long end = new Date().getTime() + timeout;
        //executing while for timeout time
        while (new Date().getTime() < end) {
            try {

                // Listen for a TCP connection request
                Socket connectionSocket = this.serverSocket.accept();

                // Handle request
                AuthenticationCallbackRequest request = new AuthenticationCallbackRequest(connectionSocket,
                        this.authPage, this.failurePage, this.successPage);
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

    public final void start() throws IOException {
        // Establish the listen socket
        // For security reasons, the third parameter is set to not accept connections from outside the localhost
        this.serverSocket = new ServerSocket(this.port, 0, InetAddress.getByName(this.host));
        this.run();
    }

    /**
     * Stops the server.
     */
    public final void stop() {
        if (this.serverSocket != null && !this.serverSocket.isClosed()) {
            try {
                this.serverSocket.close();
            } catch (IOException ignored) {
                ignored.printStackTrace();
            } finally {
                this.serverSocket = null;
            }
        }
    }
}
