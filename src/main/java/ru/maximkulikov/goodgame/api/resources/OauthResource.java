package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.auth.Authenticator;
import ru.maximkulikov.goodgame.api.handlers.OauthResourceResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.OauthResponseHandler;
import ru.maximkulikov.goodgame.api.models.AccessToken;
import ru.maximkulikov.goodgame.api.models.OauthResourceCheck;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
public class OauthResource extends AbstractResource {

    private static final String CODE = "code";

    private static final String OAUTH = "%s/oauth";

    private static final String GRANT_TYPE = "grant_type";

    private static final String REFRESH_TOKEN = "refresh_token";

    private static final String CLIENT_ID = "client_id";

    private static final String CLIENT_SECRET = "client_secret";

    private static final String REDIRECT_URI = "redirect_uri";

    private static final String AUTHORIZATION_CODE = "authorization_code";

    private GoodGame gg;

    public OauthResource(final String defaultBaseUrl, final int defaultApiVersion, final GoodGame gg) {
        super(defaultBaseUrl, defaultApiVersion);
        this.gg = gg;
    }


    public final void getAccessToken(final boolean useAutorizationCode, final OauthResponseHandler handler) {

        String url = String.format(OAUTH, getBaseUrl());

        RequestParams params = new RequestParams();

        params.put(CLIENT_ID, this.gg.getClientId());
        params.put(CLIENT_SECRET, this.gg.getClientSecret());

        if (useAutorizationCode) {
            params.put(REDIRECT_URI, this.gg.getRedirectUri().toString());
            params.put(CLIENT_ID, this.gg.getClientId());

            params.put(CODE, this.gg.auth().getAutorizationCode());
            params.put(GRANT_TYPE, AUTHORIZATION_CODE);

        } else {

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
                    handler.onFailure(e);
                }
            }
        });


    }

    /**
     * Используйте метод {@link #getAccessToken(boolean useAutorizationCode, OauthResponseHandler handler)}
     */
    @Deprecated
    public final void getAccessToken(final Authenticator authenticator, final String clientSecret,
                                     final boolean useAutorizationCode, final OauthResponseHandler handler) {
        String url = String.format(OAUTH, getBaseUrl());

        RequestParams params = new RequestParams();

        params.put(CLIENT_ID, this.gg.getClientId());
        params.put(CLIENT_SECRET, clientSecret);

        if (useAutorizationCode) {
            params.put(REDIRECT_URI, authenticator.getRedirectUri().toString());
            params.put(CLIENT_ID, gg.getClientId());

            params.put(CODE, authenticator.getAutorizationCode());
            params.put(GRANT_TYPE, AUTHORIZATION_CODE);

        } else {

            params.put(GRANT_TYPE, REFRESH_TOKEN);
            params.put(REFRESH_TOKEN, authenticator.getRefreshToken());

        }

        this.configureHeaders();
        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {

                    AccessToken value = objectMapper.readValue(content, AccessToken.class);
                    authenticator.setAccessToken(value.getAccessToken());
                    authenticator.setRefreshToken(value.getRefreshToken());

                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

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
                    handler.onFailure(e);
                }
            }
        });
    }
}
