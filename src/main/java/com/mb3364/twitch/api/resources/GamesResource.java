package com.mb3364.twitch.api.resources;

import com.mb3364.http.RequestParams;
import com.mb3364.twitch.api.handlers.GameResponseHandler;
import com.mb3364.twitch.api.handlers.GamesResponseHandler;
import com.mb3364.twitch.api.models.Game;
import com.mb3364.twitch.api.models.GamesContainer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The {@link GamesResource} provides the functionality
 * to access the <code>/games</code> endpoints of the Twitch API.
 *
 * @author Matthew Bell
 */
public class GamesResource extends AbstractResource {

    /**
     * Construct the resource using the Twitch API base URL and specified API version.
     *
     * @param baseUrl    the base URL of the Twitch API
     * @param apiVersion the requested version of the Twitch API
     */
    public GamesResource(String baseUrl, int apiVersion) {
        super(baseUrl, apiVersion);
    }


    public void getGames (final GamesResponseHandler handler) {
        String url = String.format("%s/games", getBaseUrl());

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    GamesContainer value = objectMapper.readValue(content, GamesContainer.class);
                    handler.onSuccess(value, value.getGames().getGames());
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public void getGames (final RequestParams params, final GamesResponseHandler handler) {
        String url = String.format("%s/games", getBaseUrl());

        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    GamesContainer value = objectMapper.readValue(content, GamesContainer.class);
                    handler.onSuccess(value, value.getGames().getGames());
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public void getGame (final String gameUrl, final GameResponseHandler handler) {
        String url = String.format("%s/games/%s", getBaseUrl(), gameUrl);

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    Game value = objectMapper.readValue(content, Game.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });

    }



}
