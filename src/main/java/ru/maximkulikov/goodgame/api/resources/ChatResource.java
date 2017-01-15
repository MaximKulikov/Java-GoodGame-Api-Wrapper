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

    public ChatResource(final String baseUrl, final int apiVersion) {
        super(baseUrl, apiVersion);
    }

    public final void getChatToken(final ChatTokenResponseHandler handler) {
        String url = String.format("%s/chat/token", getBaseUrl());

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, String content) {
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
