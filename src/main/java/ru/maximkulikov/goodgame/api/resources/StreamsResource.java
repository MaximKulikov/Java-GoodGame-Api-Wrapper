package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import lombok.extern.slf4j.Slf4j;
import ru.maximkulikov.goodgame.api.handlers.StreamChannelResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.StreamsResponseHandler;
import ru.maximkulikov.goodgame.api.models.ChannelContainer;
import ru.maximkulikov.goodgame.api.models.EmbededChannels;

/**
 * {@link StreamsResource} предоставляет функциональность к ресурсам стрима
 *
 * @author Maxim Kulikov
 */
@Slf4j
public class StreamsResource extends AbstractResource {

    private static final String PARAMETERS_NULL = "{} parameters are null";

    public StreamsResource(final String baseUrl, final int apiVersion) {
        super(baseUrl, apiVersion);
    }

    /**
     * Получение информации о конкретном стриме
     *
     * @param channel Идентификатор стрима, может быть как символьным ключем канала (Пример:
     *                http://api2.goodgame.ru/streams/Miker), так и числовым id (Пример:
     *                http://api2.goodgame.ru/streams/5).
     * @param handler
     */
    public final boolean getChannel(final String channel, final StreamChannelResponseHandler handler) {
        if (channel == null) {
            log.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
        String url = String.format("%s/streams/%s", getBaseUrl(), channel);

        this.configureHeaders();
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    ChannelContainer value = objectMapper.readValue(content, ChannelContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    log.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }

    /**
     * Получение информации обо всех онлайн стримах
     * на Goodgame.
     *
     * @param handler
     */
    public final boolean getStreams(final StreamsResponseHandler handler) {
        String url = String.format("%s/streams", getBaseUrl());

        this.configureHeaders();
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    EmbededChannels value = objectMapper.readValue(content, EmbededChannels.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    log.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }

    /**
     * Получение информации обо всех онлайн стримах
     * на Goodgame. Можно использовать query-параметры.
     *
     * @param params
     * @param handler
     */
    public final boolean getStreams(final RequestParams params, final StreamsResponseHandler handler) {
        if (params == null) {
            log.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }

        String url = String.format("%s/streams", getBaseUrl());

        this.configureHeaders();
        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    EmbededChannels value = objectMapper.readValue(content, EmbededChannels.class);
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
