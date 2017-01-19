package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.auth.Authenticator;
import ru.maximkulikov.goodgame.api.handlers.GitHubChannelSubscribersResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.GitHubSharedHandler;
import ru.maximkulikov.goodgame.api.handlers.GitHubTokenHandler;
import ru.maximkulikov.goodgame.api.models.GitHubSubscribers;
import ru.maximkulikov.goodgame.api.models.GitHubToken;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public class GithubResource extends AbstractResource {


    public GithubResource(final String baseUrl) {
        super(baseUrl);
    }

    public final void getChannelStatus(final String channelId, final GitHubSharedHandler handler) {
        String url = String.format("%s/getchannelstatus", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("id", channelId);
        params.put("fmt", "json");

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {

                handler.onSuccess(content);

            }
        });
    }

    public final void getChannelSubscribers(final Authenticator authenticator,
                                            final GitHubChannelSubscribersResponseHandler handler) {
        String url = String.format("%s/getchannelsubscribers", getBaseUrl());

        RequestParams params = new RequestParams();
        if (authenticator.getAccessToken() != null) {
            params.put("oauth_token ", authenticator.getAccessToken());
        } else {
            params.put("oauth_token ", "");
        }
        params.put("fmt", "json");

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {

                try {
                    GitHubSubscribers value = objectMapper.readValue(content, GitHubSubscribers.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public final void getChannelsByGame(final String gameUrl, final GitHubSharedHandler handler) {
        String url = String.format("%s/getchannelsbygame", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("game", gameUrl);
        params.put("fmt", "json");

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {

                handler.onSuccess(content);

            }
        });
    }

    public final void getGgChannelStatus(final String id, final GitHubSharedHandler handler) {
        String url = String.format("%s/getggchannelstatus", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("fmt", "json");

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {

                handler.onSuccess(content);

            }
        });
    }

    public final void getToken(final String username, final String password, final Authenticator authenticator, final GitHubTokenHandler handler) {
        String url = String.format("%s/token", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("username", username);
        params.put("password", password);
        params.put("fmt", "json");

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    GitHubToken value = objectMapper.readValue(content, GitHubToken.class);
                    authenticator.setAccessToken(value.getAccessToken());
                    authenticator.setRefreshToken(value.getRefreshToken());
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }

            }
        });
    }

    public final void getUpcomingBroadcast(final String id, final GitHubSharedHandler handler) {
        String url = String.format("%s/getupcomingbroadcast", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("fmt", "json");

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {

                handler.onSuccess(content);

            }
        });
    }
}
