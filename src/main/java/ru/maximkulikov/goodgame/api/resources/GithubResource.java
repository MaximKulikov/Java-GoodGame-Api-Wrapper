package ru.maximkulikov.goodgame.api.resources;

import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.handlers.ChannelStatusResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.GitHubChannelSubscribersResponseHandler;
import ru.maximkulikov.goodgame.api.models.GitHubSubscribers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public class GithubResource extends AbstractResource {


    public GithubResource(String baseUrl) {
        super(baseUrl);
    }

    public void getChannelStatus(final String id, final ChannelStatusResponseHandler handler ) {
        String url = String.format("%s/getchannelstatus", getBaseUrl());

        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("fmt", "json");
        RequestParams params = new RequestParams();
        params.put(map);

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {

                handler.onSuccess(content);

//                try {
//
//                    ChannelStatus value = objectMapper.readValue(content, ChannelStatus.class);
//                    handler.onSuccess(value);
//                } catch (IOException e) {
//                    handler.onFailure(e);
//                }
            }
        });
    }

    public void getGgChannelStatus(final String id, final ChannelStatusResponseHandler handler ) {
        String url = String.format("%s/getggchannelstatus", getBaseUrl());

        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("fmt", "json");
        RequestParams params = new RequestParams();
        params.put(map);

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {

                handler.onSuccess(content);

//                try {
//
//                    ChannelStatus value = objectMapper.readValue(content, ChannelStatus.class);
//                    handler.onSuccess(value);
//                } catch (IOException e) {
//                    handler.onFailure(e);
//                }
            }
        });
    }

    public void getUpcomingBroadcast(final String id, final ChannelStatusResponseHandler handler ) {
        String url = String.format("%s/getggchannelstatus", getBaseUrl());

        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("fmt", "json");
        RequestParams params = new RequestParams();
        params.put(map);

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {

                handler.onSuccess(content);

//                try {
//
//                    ChannelStatus value = objectMapper.readValue(content, ChannelStatus.class);
//                    handler.onSuccess(value);
//                } catch (IOException e) {
//                    handler.onFailure(e);
//                }
            }
        });
    }

    public void getChannelsByGame(final String gameUrl, final ChannelStatusResponseHandler handler ) {
        String url = String.format("%s/getchannelsbygame", getBaseUrl());

        Map<String, String> map = new HashMap<>();
        map.put("game",gameUrl);
        map.put("fmt", "json");
        RequestParams params = new RequestParams();
        params.put(map);

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {

                handler.onSuccess(content);

//                try {
//
//                    ChannelStatus value = objectMapper.readValue(content, ChannelStatus.class);
//                    handler.onSuccess(value);
//                } catch (IOException e) {
//                    handler.onFailure(e);
//                }
            }
        });
    }

    public void getToken(final String username,final String password, final ChannelStatusResponseHandler handler ) {
        String url = String.format("%s/token", getBaseUrl());

        Map<String, String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("fmt", "json");
        RequestParams params = new RequestParams();
        params.put(map);

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {

                handler.onSuccess(content);

//                try {
//
//                    ChannelStatus value = objectMapper.readValue(content, ChannelStatus.class);
//                    handler.onSuccess(value);
//                } catch (IOException e) {
//                    handler.onFailure(e);
//                }
            }
        });
    }


    public void getChannelSubscribers(final String oauthToken, final GitHubChannelSubscribersResponseHandler handler ) {
        String url = String.format("%s/getchannelsubscribers", getBaseUrl());


        Map<String, String> map = new HashMap<>();
        map.put("oauth_token ",oauthToken);
        map.put("fmt", "json");
        RequestParams params = new RequestParams();
        params.put(map);

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {

                try {

                    GitHubSubscribers value = objectMapper.readValue(content, GitHubSubscribers.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }




}
