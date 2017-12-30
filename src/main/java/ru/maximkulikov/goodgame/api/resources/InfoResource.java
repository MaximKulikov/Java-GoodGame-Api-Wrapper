package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.handlers.InfoResponseHandler;
import ru.maximkulikov.goodgame.api.models.Info;

/**
 * {@link InfoResource} предоставляет функциональность к информационным ресурсам
 *
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
public class InfoResource extends AbstractResource {
    private static final Logger logger = LoggerFactory.getLogger(InfoResource.class);

    public InfoResource(final String baseUrl, final int apiVersion) {
        super(baseUrl, apiVersion);
    }

    /**
     * Получение информации по Access Token'у
     *
     * @param handler
     */
    public final boolean getInfo(final InfoResponseHandler handler) {
        String url = String.format("%s/info", getBaseUrl());

        this.configureHeaders();
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    Info value = objectMapper.readValue(content, Info.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }
}
