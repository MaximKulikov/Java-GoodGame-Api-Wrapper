package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.mb3364.http.AsyncHttpClient;
import com.mb3364.http.StringHttpResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.BaseFailureHandler;
import ru.maximkulikov.goodgame.api.models.Error;

/**
 * AbstractResource is the abstract base class of a Twitch resource.
 * A resource provides the functionality to access the REST endpoints of the Twitch API.
 *
 * @author Matthew Bell
 */
public abstract class AbstractResource {

    protected static final ObjectMapper objectMapper = new ObjectMapper();

    protected static final AsyncHttpClient http = new AsyncHttpClient();

    // Base url for twitch rest api
    private final String baseUrl;


    protected AbstractResource(final String baseUrl, int apiVersion) {
        this.baseUrl = baseUrl;
        // Specify API version
        http.setHeader("ACCEPT", "application/vnd.goodgame.v" + Integer.toString(apiVersion) + "+json");

        this.configureObjectMapper();
    }

    protected AbstractResource(final String baseUrl) {
        this.baseUrl = baseUrl;
        String applicationJson = "application/json";
        http.setHeader("Accept", applicationJson);
        http.setHeader("Content-Type", applicationJson);
    }


    private void configureObjectMapper() {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }

    protected final String getBaseUrl() {
        return this.baseUrl;
    }

    public final void setAccessToken(String accessToken) {
        String authorization = "Authorization";
        if (accessToken != null && accessToken.length() > 0) {
            http.setHeader(authorization, String.format("Bearer %s", accessToken));
        } else {
            http.removeHeader(authorization);
        }
    }

    public final void setClientId(final String clientId) {
        String clientIdKey = "Client-ID";
        if (clientId != null && clientId.length() > 0) {
            http.setHeader(clientIdKey, clientId);
        } else {
            http.removeHeader(clientIdKey);
        }
    }

    protected static abstract class GoodGameHttpResponseHandler extends StringHttpResponseHandler {

        private BaseFailureHandler apiHandler;

        public GoodGameHttpResponseHandler(BaseFailureHandler apiHandler) {
            this.apiHandler = apiHandler;
        }

        @Override
        public abstract void onSuccess(int statusCode, Map<String, List<String>> headers, String content);

        @Override
        public final void onFailure(final int statusCode, Map<String, List<String>> headers, String content) {
            try {
                if (content.length() > 0) {
                    Error error = objectMapper.readValue(content, Error.class);
                    this.apiHandler.onFailure(statusCode, error.getStatusText(), error.getMessage());
                } else {
                    this.apiHandler.onFailure(statusCode, "", "");
                }
            } catch (IOException e) {
                this.apiHandler.onFailure(e);
            }
        }

        @Override
        public final void onFailure(Throwable throwable) {
            this.apiHandler.onFailure(throwable);
        }
    }
}
