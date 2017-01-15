package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.handlers.GameResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.GamesResponseHandler;
import ru.maximkulikov.goodgame.api.models.Game;
import ru.maximkulikov.goodgame.api.models.GamesContainer;

/**
 * The {@link GamesResource} provides the functionality
 * to access the <code>/games</code> endpoints of the Twitch API.
 *
 * @author Matthew Bell
 */
public class GamesResource extends AbstractResource {

    public GamesResource(final String baseUrl, int apiVersion) {
        super(baseUrl, apiVersion);
    }

    public final void getGame(final String gameUrl, final GameResponseHandler handler) {
        String url = String.format("%s/games/%s", getBaseUrl(), gameUrl);

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    Game value = objectMapper.readValue(content, Game.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public final void getGames(final RequestParams params, final GamesResponseHandler handler) {
        String url = String.format("%s/games", getBaseUrl());

        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    GamesContainer value = objectMapper.readValue(content, GamesContainer.class);
                    handler.onSuccess(value, value.getGames().getGames());
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public final void getGames(final GamesResponseHandler handler) {
        String url = String.format("%s/games", getBaseUrl());

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    GamesContainer value = objectMapper.readValue(content, GamesContainer.class);
                    handler.onSuccess(value, value.getGames().getGames());
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }
}
