package ru.maximkulikov.goodgame.api.resources;

import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.auth.Authenticator;
import ru.maximkulikov.goodgame.api.handlers.OauthResponseHandler;
import ru.maximkulikov.goodgame.api.models.AccessToken;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
public class OauthResource extends AbstractResource {


    public OauthResource(String defaultBaseUrl, int defaultApiVersion) {
        super(defaultBaseUrl, defaultApiVersion);
    }

    /**
     * Returns a AccessToken object of authenticated user.
     *
     * @param handler the response handler
     */
    public void getAccessToken(final Authenticator authenticator, String clientSecret, final OauthResponseHandler handler) {
        String url = String.format("%s/oauth", getBaseUrl());
        RequestParams params = new RequestParams();
        Map<String, String> map = new HashMap<>();
        map.put("redirect_uri", authenticator.getRedirectUri().toString());
        map.put("client_id", authenticator.getClientId());
        map.put("client_secret", clientSecret);
        map.put("code", authenticator.getAutorizationCode());
        map.put("grant_type", "authorization_code");
        params.put(map);

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
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

}
