package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import ru.maximkulikov.goodgame.api.handlers.ChatTokenResponseHandler;
import ru.maximkulikov.goodgame.api.models.ChatToken;

/**
 * The {@link ChatResource} provides the functionality
 * to access the <code>/chat</code> endpoints of the Twitch API.
 *
 * @author Matthew Bell
 */
public class ChatResource extends AbstractResource {

    /**
     * Construct the resource using the Twitch API base URL and specified API version.
     *
     * @param baseUrl    the base URL of the Twitch API
     * @param apiVersion the requested version of the Twitch API
     */
    public ChatResource(String baseUrl, int apiVersion) {
        super(baseUrl, apiVersion);
    }






    public void getChatToken(final ChatTokenResponseHandler handler) {
        String url = String.format("%s/chat/token", getBaseUrl());

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    ChatToken value = objectMapper.readValue(content, ChatToken.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }


}
