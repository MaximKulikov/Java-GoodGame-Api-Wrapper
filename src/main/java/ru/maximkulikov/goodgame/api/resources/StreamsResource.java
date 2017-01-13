package ru.maximkulikov.goodgame.api.resources;

import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.handlers.StreamChannelResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.StreamResponseHandler;
import ru.maximkulikov.goodgame.api.models.ChannelContainer;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class StreamsResource extends AbstractResource {


    public StreamsResource(String baseUrl, int apiVersion) {
        super(baseUrl, apiVersion);
    }


    /**
     * Получение информации обо всех онлайн стримах на Goodgame. Можно использовать query-параметры.
     * <p>The stream object in the onSuccess() response will be <code>null</code> if the stream is offline.</p>
     */

    public void getStreams(final StreamResponseHandler handler) {
        String url = String.format("%s/streams", getBaseUrl());

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    ChannelContainer value = objectMapper.readValue(content, ChannelContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public void getStreams(final RequestParams params, final StreamResponseHandler handler) {

        String url = String.format("%s/streams", getBaseUrl());

        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    ChannelContainer value = objectMapper.readValue(content, ChannelContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public void getChannel(final String channel, final StreamChannelResponseHandler handler) {
        String url = String.format("%s/streams/%s", getBaseUrl(), channel);

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    ChannelContainer value = objectMapper.readValue(content, ChannelContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public void getChannel(final String channel, final RequestParams params, final StreamChannelResponseHandler handler) {

        String url = String.format("%s/streams/%s", getBaseUrl(), channel);

        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    ChannelContainer value = objectMapper.readValue(content, ChannelContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

}