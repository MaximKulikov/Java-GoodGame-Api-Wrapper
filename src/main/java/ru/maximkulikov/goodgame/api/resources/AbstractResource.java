package ru.maximkulikov.goodgame.api.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.mb3364.http.AsyncHttpClient;
import com.mb3364.http.StringHttpResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.BaseFailureHandler;
import ru.maximkulikov.goodgame.api.models.Error;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * AbstractResource абстрактный базовый класс ресурсов GoodGame.
 * Ресурсы предоставляют непосредственный доступ к вызовам GoodGame API.
 *
 * @author Matthew Bell
 * @author Maxim Kulikov
 */
public abstract class AbstractResource {

    private final static String APPLICATIONJSON = "application/json";

    protected static final ObjectMapper objectMapper = new ObjectMapper();

    protected static final AsyncHttpClient http = new AsyncHttpClient();

    // Base url for twitch rest api
    private final String baseUrl;

    private Integer apiVersion = null;


    protected AbstractResource(final String baseUrl, final int apiVersion) {
        this.baseUrl = baseUrl;
        this.apiVersion = apiVersion;

        this.configureObjectMapper();

        this.configureHeaders();
    }

    protected void configureHeaders() {

        http.removeHeader("ACCEPT");
        http.removeHeader("Content-Type");
        http.removeHeader("Cookie");

        http.setHeader("Content-Type", APPLICATIONJSON);

        if (this.apiVersion == null) {
            http.setHeader("ACCEPT", APPLICATIONJSON);
        } else {
            http.setHeader("ACCEPT", "application/vnd.goodgame.v" + Integer.toString(this.apiVersion) + "+json");
        }


    }

    ;

    protected AbstractResource(final String baseUrl) {
        this.baseUrl = baseUrl;
        this.configureHeaders();

    }

    private void configureObjectMapper() {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }

    protected final String getBaseUrl() {
        return this.baseUrl;
    }

    /**
     * @param accessToken Устанавливает взаголовок запроса Access Token
     * @see ru.maximkulikov.goodgame.api.auth.Authenticator#setAccessToken(String)
     */
    public final void setAccessToken(final String accessToken) {
        String authorization = "Authorization";
        if (accessToken != null && accessToken.length() > 0) {
            http.setHeader(authorization, String.format("Bearer %s", accessToken));
        } else {
            http.removeHeader(authorization);
        }
    }

    /**
     * @param clientId Устанавливает Client ID oauth приложения в заголовок запросов
     * @see ru.maximkulikov.goodgame.api.GoodGame#setClientId(String)
     */
    public final void setClientId(final String clientId) {
        String clientIdKey = "Client-ID";
        if (clientId != null && clientId.length() > 0) {
            http.setHeader(clientIdKey, clientId);
        } else {
            http.removeHeader(clientIdKey);
        }
    }

    protected abstract static class GoodGameHttpResponseHandler extends StringHttpResponseHandler {

        private BaseFailureHandler apiHandler;

        public GoodGameHttpResponseHandler(final BaseFailureHandler apiHandler) {
            this.apiHandler = apiHandler;
        }

        @Override
        public abstract void onSuccess(int statusCode, Map<String, List<String>> headers, String content);

        @Override
        public final void onFailure(final int statusCode,
                                    final Map<String, List<String>> headers, final String content) {
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
        public final void onFailure(final Throwable throwable) {
            this.apiHandler.onFailure(throwable);
        }
    }
}
