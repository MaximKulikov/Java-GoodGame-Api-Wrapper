package com.mb3364.twitch.api.resources;

import com.mb3364.http.RequestParams;
import com.mb3364.twitch.api.handlers.SmilesResponseHandler;
import com.mb3364.twitch.api.models.SmilesContainer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public class SmilesResource extends AbstractResource {
    public SmilesResource(String baseUrl, int apiVersion) {
        super(baseUrl, apiVersion);
    }

    protected SmilesResource(String baseUrl) {
        super(baseUrl);
    }

    public void getSmiles (final SmilesResponseHandler handler) {
        String url = String.format("%s/smiles", getBaseUrl() );

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });

    }

    public  void getSmiles (RequestParams params, final SmilesResponseHandler handler) {
        String url = String.format("%s/smiles", getBaseUrl() );

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public  void getChannelSmiles (final long channelID, final SmilesResponseHandler handler) {
        String url = String.format("%s/smiles/%s", getBaseUrl(), channelID );

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });

    }

    public  void getChannelSmiles (final long channelId, final RequestParams params, final SmilesResponseHandler handler) {
        String url = String.format("%s/smiles/%s", getBaseUrl(), channelId );

        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
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
