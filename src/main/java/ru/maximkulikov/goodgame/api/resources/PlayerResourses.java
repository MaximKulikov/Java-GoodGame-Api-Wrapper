package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.handlers.PlayerResponseHandler;
import ru.maximkulikov.goodgame.api.models.Player;

/**
 * {@link PlayerResourses} предоставляет фукциональность к ресурсам информации о плеере
 *
 * @author Maxim Kulikov
 * @since 29.12.2016
 */
public class PlayerResourses extends AbstractResource {
    private static final Logger logger = LoggerFactory.getLogger(PlayerResourses.class);

    public PlayerResourses(final String defaultBaseUrl, final int defaultApiVersion) {
        super(defaultBaseUrl, defaultApiVersion);
    }

    /**
     * Получение информации о плеере
     *
     * @param channelId Идентификатор канала
     * @param handler
     */
    public final boolean getPlayer(final String channelId, final PlayerResponseHandler handler) {
        String url = String.format("%s/player/%s", getBaseUrl(), channelId);

        this.configureHeaders();
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    Player value = objectMapper.readValue(content, Player.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }
}
