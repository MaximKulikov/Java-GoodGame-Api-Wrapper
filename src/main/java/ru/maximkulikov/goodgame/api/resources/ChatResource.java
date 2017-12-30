package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import ru.maximkulikov.goodgame.api.handlers.ChatTokenResponseHandler;
import ru.maximkulikov.goodgame.api.models.ChatToken;

/**
 * {@link ChatResource} предоставляет функциональность к ресурсам чата, доступным по запросам <code>/chat/</code>.
 *
 * @author Maxim Kulikov
 */
public class ChatResource extends AbstractResource {

    public ChatResource(final String baseUrl, final int apiVersion) {
        super(baseUrl, apiVersion);
    }

    /**
     * Получение токена чата для конкретного пользователя. Id-пользователя определяется из Access Token'a.<br>
     * Требуется OAuth 2.0 аутентификация. <br>
     * Scope: chat.token
     *
     * @param handler
     */
    public final boolean getChatToken(final ChatTokenResponseHandler handler) {
        String url = String.format("%s/chat/token", getBaseUrl());

        this.configureHeaders();
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    ChatToken value = objectMapper.readValue(content, ChatToken.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }
}
