package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.OauthResourceResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.OauthResponseHandler;
import ru.maximkulikov.goodgame.api.models.AccessToken;
import ru.maximkulikov.goodgame.api.models.OauthResourceCheck;

/**
 * {@link OauthResource} предоствляет мкханизмы авторизации с помощью токена
 *
 * @author Maxim Kulikov
 * @since 29.12.2016
 */
public class OauthResource extends AbstractResource {
    private static final Logger logger = LoggerFactory.getLogger(OauthResource.class);
    private static final String PARAMETERS_NULL = "{} parameters are null";
    private static final String CODE = "code";

    private static final String OAUTH = "%s/oauth";

    private static final String GRANT_TYPE = "grant_type";

    private static final String REFRESH_TOKEN = "refresh_token";

    private static final String CLIENT_ID = "client_id";

    private static final String CLIENT_SECRET = "client_secret";

    private static final String REDIRECT_URI = "redirect_uri";

    private static final String AUTHORIZATION_CODE = "authorization_code";

    private GoodGame gg;

    /**
     * @param defaultBaseUrl    Базовая ссылка на ресурс
     * @param defaultApiVersion Версия API
     * @param gg                Ссылка на объект {@link GoodGame}
     */
    public OauthResource(final String defaultBaseUrl, final int defaultApiVersion, final GoodGame gg) {
        super(defaultBaseUrl, defaultApiVersion);
        this.gg = gg;
    }

    /**
     * Получение токена доступа. При удачном выполнении токен запоминается в системе и в последующих запросах используется автоматически
     *
     * @param useAutorizationCode Если требуется использовать Authorisation Code - <i>true</i>, если Refresh Token - <i>false</i>
     * @param handler
     */
    public final boolean getAccessToken(final boolean useAutorizationCode, final OauthResponseHandler handler) {

        if (this.gg.auth().getRedirectURI() == null || this.gg.getClientId() == null) {
            logger.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }

        String url = String.format(OAUTH, getBaseUrl());

        RequestParams params = new RequestParams();

        params.put(CLIENT_ID, this.gg.getClientId());
        params.put(CLIENT_SECRET, this.gg.getClientSecret());

        if (useAutorizationCode) {

            if (this.gg.auth().getAuthorizationCode() == null) {
                logger.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
                return false;
            }
            params.put(REDIRECT_URI, this.gg.auth().getRedirectURI().toString());

            params.put(CODE, this.gg.auth().getAuthorizationCode());
            params.put(GRANT_TYPE, AUTHORIZATION_CODE);

        } else {

            if (this.gg.auth().getRefreshToken() == null) {
                logger.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
                return false;
            }
            params.put(GRANT_TYPE, REFRESH_TOKEN);
            params.put(REFRESH_TOKEN, this.gg.auth().getRefreshToken());

        }

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    AccessToken value = objectMapper.readValue(content, AccessToken.class);
                    gg.auth().setAccessToken(value.getAccessToken());
                    gg.setAccessTokenToHeaders(value.getAccessToken());
                    gg.auth().setRefreshToken(value.getRefreshToken());
                    handler.onSuccess(value);

                } catch (IOException e) {
                    logger.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }

    /**
     * Метод можно использовать для проверки возможности отправки запросов от имени пользователя с использованием токена
     *
     * @param handler
     */
    public final void getResource(final OauthResourceResponseHandler handler) {
        String url = String.format("%s/oauth/resource", getBaseUrl());

        this.configureHeaders();
        http.post(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    OauthResourceCheck value = objectMapper.readValue(content, OauthResourceCheck.class);
                    handler.onSuccess(value);

                } catch (IOException e) {
                    logger.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
    }
}
