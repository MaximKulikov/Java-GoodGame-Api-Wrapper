package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import ru.maximkulikov.goodgame.api.handlers.PlayerResponseHandler;
import ru.maximkulikov.goodgame.api.models.Player;

/**
 * {@link PlayerResourses} предоставляет фукциональность к ресурсам информации о плеере
 *
 * @author Maxim Kulikov
 * @since 29.12.2016
 */
@Slf4j
public class PlayerResourses extends AbstractResource {
    
    private static final String PARAMETERS_NULL = "{} parameters are null";

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
        if (channelId == null) {
            log.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
        String url = String.format("%s/player/%s", getBaseUrl(), channelId);

        this.configureHeaders();
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    Player value = objectMapper.readValue(content, Player.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    log.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }
}
