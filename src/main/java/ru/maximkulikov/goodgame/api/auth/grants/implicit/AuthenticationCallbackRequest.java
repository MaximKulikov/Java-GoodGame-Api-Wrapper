package ru.maximkulikov.goodgame.api.auth.grants.implicit;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class AuthenticationCallbackRequest implements Runnable {

    // as specified by HTTP/1.1 spec
    private static final String EOL = "\r\n";

    private static final String UTF8 = "UTF-8";

    private Socket socket;

    private URL authPage;

    private URL failurePage;

    private URL successPage;

    // Will receive auth callbacks
    private AuthenticationListener authenticationListener;

    public AuthenticationCallbackRequest(final Socket socket, URL authPage, URL failurePage, URL successPage) {
        this.socket = socket;
        this.authPage = authPage;
        this.failurePage = failurePage;
        this.successPage = successPage;
    }


    private static void sendFileBytes(InputStream fis, OutputStream os) throws IOException {
        // Construct a 1K buffer to hold bytes on their way to the socket.
        byte[] buffer = new byte[1024];
        int bytes;
        // Copy requested file into the socket's output stream.
        while ((bytes = fis.read(buffer)) != -1) {
            os.write(buffer, 0, bytes);
        }
    }


    private static Map<String, String> extractQueryParams(String request) {
        Map<String, String> params = new HashMap<>();

        String[] parts = request.split("\\?", 2);
        if (parts.length < 2) {
            // No params
            return params;
        }

        String query = parts[1];
        for (String param : query.split("&")) {
            String[] pair = param.split("=");

            try {
                String key = URLDecoder.decode(pair[0], UTF8);
                String value = "";
                if (pair.length > 1) {
                    value = URLDecoder.decode(pair[1], UTF8);
                }
                params.put(key, value);
            } catch (UnsupportedEncodingException ignored) {
            }
        }

        return params;
    }

    public final void setAuthenticationListener(final AuthenticationListener receiver) {
        this.authenticationListener = receiver;
    }

    @Override
    public final void run() {
        try {
            processRequest();
        } catch (Exception ignored) {
        }
    }


    private void processRequest() throws IOException {
        // Get a reference to the socket's input and output streams.
       // InputStream is = socket.getInputStream();
        DataOutputStream os = new DataOutputStream(this.socket.getOutputStream());

        // Set up input stream filters.
        BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

        // Get the request line of the HTTP request message.
        String requestLine = br.readLine();

        // Store the request line for debugging.
        //String rawRequest = "\n" + requestLine;

        // Read the header lines.
//        String headerLine = null;
//        while ((headerLine = br.readLine()).length() != 0) {
//            //rawRequest += headerLine + "\n";
//        }

        // DEBUG: Print request
        //System.out.println(rawRequest);

        // Parse the request line.
        StringTokenizer tokens = new StringTokenizer(requestLine);
        // Request method, which should be "GET"
        //  String requestMethod = tokens.nextToken();
        String requestFilename = tokens.nextToken();
        Map<String, String> queryParams = extractQueryParams(requestFilename);

        // If we have the token, send the success page
        String accessToken = queryParams.get("code");
        String state = queryParams.get("state");
        String[] scopes = new String[0];

        // See if there is an error message, send the failure page
        String error = queryParams.get("error");
        String errorDescription = queryParams.get("error_description");

        //System.out.println("file: " + requestFilename);

        // Open the requested file.
        InputStream fis;
        String contentTypeLine;
        if (requestFilename.startsWith("/gg-auth.js") || requestFilename.startsWith("/gg-auth-success.js")) {
            fis = getClass().getResourceAsStream(requestFilename);
            contentTypeLine = "Content-type: text/javascript" + EOL;
        } else {
            if (accessToken != null) {
                fis = this.successPage.openStream();
            } else if (error != null) {
                fis = this.failurePage.openStream();
            } else {
                fis = this.authPage.openStream();
            }
            contentTypeLine = "Content-type: text/html" + EOL;
        }

        boolean fileExists = fis != null;

        // Construct the response message.
        String statusLine = null;
        String entityBody = null;
        if (fileExists) {
            statusLine = "HTTP/1.1 200 OK" + EOL;
        } else {
            statusLine = "HTTP/1.1 404 Not Found" + EOL;
            entityBody = "404 Not Found";
        }

        // Send the status line.
        os.writeBytes(statusLine);

        // Send the content type line.
        os.writeBytes(contentTypeLine);

        // Send a blank line to indicate the end of the header lines.
        os.writeBytes(EOL);

        // Send the entity body.
        if (fileExists) {
            sendFileBytes(fis, os);
            fis.close();
        } else {
            os.writeBytes(entityBody);
        }

        // Close streams and socket.
        os.close();
        br.close();
        this.socket.close();

        // Send callbacks
        if (this.authenticationListener != null) {
            // Send callback if access token received
            if (accessToken != null) {

                this.authenticationListener.onAccessTokenReceived(accessToken, state);
            }
            // Send callback if authorization error
            if (error != null) {
                this.authenticationListener.onAuthenticationError(error, errorDescription);
            }
        }
    }
}
