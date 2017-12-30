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
 * {@link GamesResource} предоствяляет функциональность к ресурсам зарегистрированных на GoodGame игр,
 * доступным по запросам <code>/games</code>.
 *
 * @author Maxim Kulikov
 */
public class GamesResource extends AbstractResource {

    public GamesResource(final String baseUrl, final int apiVersion) {
        super(baseUrl, apiVersion);
    }

    /**
     * Получение коллекции игр
     *
     * @param handler
     */
    public final boolean getGames(final GamesResponseHandler handler) {
        String url = String.format("%s/games", getBaseUrl());

        this.configureHeaders();
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    GamesContainer value = objectMapper.readValue(content, GamesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }

    /**
     * Получение коллекции игр
     *  @param params  Дополнительные параметры: page (номер страницы при постраничном выводе) и filter (фильтр по
     *                названию игры)
     * @param handler
     */
    public final boolean getGames(final RequestParams params, final GamesResponseHandler handler) {
        String url = String.format("%s/games", getBaseUrl());

        this.configureHeaders();
        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    GamesContainer value = objectMapper.readValue(content, GamesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }

    /**
     * Получение информации по игре, зная ее url
     *  @param gameUrl URL игры
     * @param handler
     */
    public final boolean getGame(final String gameUrl, final GameResponseHandler handler) {
        String url = String.format("%s/games/%s", getBaseUrl(), gameUrl);

        this.configureHeaders();
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    Game value = objectMapper.readValue(content, Game.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }
}
