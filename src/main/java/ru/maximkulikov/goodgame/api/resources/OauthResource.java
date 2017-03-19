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

    private GoodGame gg;

    public OauthResource(final String defaultBaseUrl, final int defaultApiVersion, GoodGame gg) {
        super(defaultBaseUrl, defaultApiVersion);
        this.gg = gg;
    }


    public final void getAccessToken(final boolean useAutorizationCode, final OauthResponseHandler handler) {

        String url = String.format("%s/oauth", getBaseUrl());

        RequestParams params = new RequestParams();

        params.put("client_id", gg.getClientId());
        params.put("client_secret", gg.getClientSecret());

        if (useAutorizationCode) {
            params.put("redirect_uri", gg.getRedirectUri().toString());
            params.put("client_id", gg.getClientId());

            params.put("code", gg.auth().getAutorizationCode());
            params.put("grant_type", "authorization_code");

        } else {

            params.put("grant_type", "refresh_token");
            params.put("refresh_token", gg.auth().getRefreshToken());

        }

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {

                    AccessToken value = objectMapper.readValue(content, AccessToken.class);
                    gg.auth().setAccessToken(value.getAccessToken());
                    gg.auth().setRefreshToken(value.getRefreshToken());

                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });


    }

    /**
     * @Deprecated
     * Используйте метод getAccessToken с двумя параметрами
     */

    @Deprecated
    public final void getAccessToken(final Authenticator authenticator, final String clientSecret,
                                     final boolean useAutorizationCode, final OauthResponseHandler handler) {
        String url = String.format("%s/oauth", getBaseUrl());

        RequestParams params = new RequestParams();

        params.put("client_id", gg.getClientId());
        params.put("client_secret", clientSecret);

        if (useAutorizationCode) {
            params.put("redirect_uri", authenticator.getRedirectUri().toString());
            params.put("client_id", gg.getClientId());

            params.put("code", authenticator.getAutorizationCode());
            params.put("grant_type", "authorization_code");

        } else {

            params.put("grant_type", "refresh_token");
            params.put("refresh_token", authenticator.getRefreshToken());

        }

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
