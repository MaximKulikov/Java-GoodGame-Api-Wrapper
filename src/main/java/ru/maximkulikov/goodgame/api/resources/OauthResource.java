package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
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


    public OauthResource(final String defaultBaseUrl, int defaultApiVersion) {
        super(defaultBaseUrl, defaultApiVersion);
    }


    public final void getAccessToken(final Authenticator authenticator, final String clientSecret, final OauthResponseHandler handler) {
        String url = String.format("%s/oauth", getBaseUrl());

        RequestParams params = new RequestParams();

        params.put("redirect_uri", authenticator.getRedirectUri().toString());
        params.put("client_id", authenticator.getClientId());
        params.put("client_secret", clientSecret);
        params.put("code", authenticator.getAutorizationCode());
        params.put("grant_type", "authorization_code");


        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, Map<String, List<String>> headers, String content) {
                try {

                    AccessToken value = objectMapper.readValue(content, AccessToken.class);

                    authenticator.setAccessToken(value);
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
            public void onSuccess(final int statusCode, Map<String, List<String>> headers, String content) {
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