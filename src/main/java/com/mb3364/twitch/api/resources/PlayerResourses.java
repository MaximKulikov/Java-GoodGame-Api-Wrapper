package com.mb3364.twitch.api.resources;

import com.mb3364.twitch.api.handlers.PlayerResponseHandler;
import com.mb3364.twitch.api.models.Player;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
public class PlayerResourses extends AbstractResource {

    public PlayerResourses(String defaultBaseUrl, int defaultApiVersion) {
        super(defaultBaseUrl, defaultApiVersion);
    }

    public void getPlayer(String playerSource, final PlayerResponseHandler handler) {
        String url = String.format("%s/player/%s", getBaseUrl(), playerSource);


        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    Player value = objectMapper.readValue(content, Player.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

}
