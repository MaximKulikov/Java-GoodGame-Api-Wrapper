package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import ru.maximkulikov.goodgame.api.handlers.InfoResponseHandler;
import ru.maximkulikov.goodgame.api.models.Info;

/**
 * {@link InfoResource} предоставляет функциональность к информационным ресурсам
 *
 * @since 04.01.2017
 * @author Maxim Kulikov
 */
public class InfoResource extends AbstractResource {

    public InfoResource(final String baseUrl, final int apiVersion) {
        super(baseUrl, apiVersion);
    }

    /**
     * Получение информации по Access Token'у
     * 
     * @param handler
     */
    public final void getInfo(final InfoResponseHandler handler) {
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
    }
}
