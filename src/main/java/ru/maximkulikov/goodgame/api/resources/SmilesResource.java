package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.handlers.SmilesResponseHandler;
import ru.maximkulikov.goodgame.api.models.SmilesContainer;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public class SmilesResource extends AbstractResource {

    public SmilesResource(final String baseUrl, final int apiVersion) {
        super(baseUrl, apiVersion);
    }

    protected SmilesResource(final String baseUrl) {
        super(baseUrl);
    }

    public final void getChannelSmiles(final long channelID, final SmilesResponseHandler handler) {
        String url = String.format("%s/smiles/%s", getBaseUrl(), channelID);

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });

    }

    public final void getChannelSmiles(final long channelId, final int page,
                                       final SmilesResponseHandler handler) {
        String url = String.format("%s/smiles/%s", getBaseUrl(), channelId);

        RequestParams params = new RequestParams();
        params.put("page", page);

        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });

    }

    public final void getSmiles(final SmilesResponseHandler handler) {
        String url = String.format("%s/smiles", getBaseUrl());

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });

    }

    public final void getSmiles(final int page, final SmilesResponseHandler handler) {
        String url = String.format("%s/smiles", getBaseUrl());
        RequestParams params = new RequestParams();
        params.put("page", page);
        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }
}
