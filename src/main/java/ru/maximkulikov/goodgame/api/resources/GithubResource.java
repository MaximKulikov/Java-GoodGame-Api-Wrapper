package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.GoodGame;
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
    private static final Logger logger = LoggerFactory.getLogger(GithubResource.class);
    private static final String ID = "id";

    private static final String FMT = "fmt";

    private static final String JSON = "json";

    private final GoodGame gg;

    public GithubResource(final String baseUrl, GoodGame goodGame) {
        super(baseUrl);
        this.gg = goodGame;
    }

    public final boolean getChannelStatus(final String channelId, final GitHubSharedHandler handler) {
        String url = String.format("%s/getchannelstatus", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put(ID, channelId);
        params.put(FMT, JSON);

        this.configureHeaders();
        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {

                handler.onSuccess(content);

            }
        });
        return true;
    }

    public final boolean getChannelSubscribers(final GitHubChannelSubscribersResponseHandler handler) {
        String url = String.format("%s/getchannelsubscribers", getBaseUrl());

        RequestParams params = new RequestParams();

        if (gg.auth().getAccessToken() != null) {
            params.put("oauth_token", gg.auth().getAccessToken());
        } else {
            params.put("oauth_token", "");
        }
        params.put(FMT, JSON);

        this.configureHeaders();


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

        return true;
    }

    public final boolean getChannelsByGame(final String gameUrl, final GitHubSharedHandler handler) {
        String url = String.format("%s/getchannelsbygame", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("game", gameUrl);
        params.put(FMT, JSON);

        this.configureHeaders();
        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {

                handler.onSuccess(content);

            }
        });
        return true;
    }

    public final boolean getGgChannelStatus(final String id, final GitHubSharedHandler handler) {
        String url = String.format("%s/getggchannelstatus", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put(ID, id);
        params.put(FMT, JSON);

        this.configureHeaders();
        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {

                handler.onSuccess(content);

            }
        });
        return true;
    }

    public final boolean getToken(final String username, final String password, final GitHubTokenHandler handler) {
        String url = String.format("%s/token", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("username", username);
        params.put("password", password);
        params.put(FMT, JSON);

        this.configureHeaders();
        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    GitHubToken value = objectMapper.readValue(content, GitHubToken.class);
                    gg.auth().setAccessToken(value.getAccessToken());
                    gg.setAccessTokenToHeaders(value.getAccessToken());
                    gg.auth().setRefreshToken(value.getRefreshToken());
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }

            }
        });
        return true;
    }

    public final boolean getUpcomingBroadcast(final String id, final GitHubSharedHandler handler) {
        String url = String.format("%s/getupcomingbroadcast", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put(ID, id);
        params.put(FMT, JSON);

        this.configureHeaders();
        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {

                handler.onSuccess(content);

            }
        });
        return true;
    }
}
