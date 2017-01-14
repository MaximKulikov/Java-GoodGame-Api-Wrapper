package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import ru.maximkulikov.goodgame.api.handlers.InfoResponseHandler;
import ru.maximkulikov.goodgame.api.models.Info;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public class InfoResource extends AbstractResource {


    public InfoResource(String baseUrl, int apiVersion) {
        super(baseUrl, apiVersion);
    }

    protected InfoResource(String baseUrl) {
        super(baseUrl);
    }

    public void getInfo (final InfoResponseHandler handler) {
        String url = String.format("%s/info", getBaseUrl());

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
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
