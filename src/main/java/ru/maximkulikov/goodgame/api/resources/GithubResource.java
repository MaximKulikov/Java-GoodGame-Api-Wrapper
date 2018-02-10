package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GithubResource extends AbstractResource {

    private static final String PARAMETERS_NULL = "{} parameters are null";
    private static final String ID = "id";
    private static final String FMT = "fmt";
    private static final String JSON = "json";

    private final GoodGame gg;

    public GithubResource(final String baseUrl, GoodGame goodGame) {
        super(baseUrl);
        this.gg = goodGame;
    }

    public final boolean getChannelStatus(final String channelId, final GitHubSharedHandler handler) {
        if (channelId == null) {
            log.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
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
                    log.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });

        return true;
    }

    public final boolean getChannelsByGame(final String gameUrl, final GitHubSharedHandler handler) {
        if (gameUrl == null) {
            log.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
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
        if (id == null) {
            log.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
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

    /**
     * Use getToken with `char[] password`  <br>
     * Delete after version 1.1
     */
    @Deprecated
    public final boolean getToken(final String username, final String password, final GitHubTokenHandler handler) {

        return getToken(username, password.toCharArray(), handler);
    }

    /**
     * DANGER. There is still some code with password as String.
     *
     * @param username
     * @param password
     * @param handler
     * @return
     */
    public final boolean getToken(final String username, char[] password, final GitHubTokenHandler handler) {
        if (username == null || password[0] == 0) {
            log.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
        String url = String.format("%s/token", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("username", username);
//TODO Избежать использования пароля
        params.put("password", String.valueOf(password));
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
                    log.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }

            }
        });
        return true;

    }

    public final boolean getUpcomingBroadcast(final String id, final GitHubSharedHandler handler) {
        if (id == null) {
            log.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
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
