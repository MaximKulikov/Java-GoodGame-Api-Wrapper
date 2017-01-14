package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.handlers.DonationsResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.PremiumsResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.SubscriberResponseHandler;
import ru.maximkulikov.goodgame.api.models.DonationsContainer;
import ru.maximkulikov.goodgame.api.models.PremiumsContainer;
import ru.maximkulikov.goodgame.api.models.SubscrurersContainer;

/**
 * The {@link ChannelsResource} provides the functionality
 * to access the <code>/channels</code> endpoints of the Twitch API.
 *
 * @author Matthew Bell
 */
public class ChannelsResource extends AbstractResource {


    public ChannelsResource(String baseUrl, int apiVersion) {
        super(baseUrl, apiVersion);
    }

    public final void getDonations(final String channel, final DonationsResponseHandler handler) {
        String url = String.format("%s/channel/%s/donations", getBaseUrl(), channel);
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    DonationsContainer value = objectMapper.readValue(content, DonationsContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public final void getDonations(final String channel, final RequestParams params, final DonationsResponseHandler handler) {
        String url = String.format("%s/channel/%s/donations", getBaseUrl(), channel);
        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    DonationsContainer value = objectMapper.readValue(content, DonationsContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public final void getPremiums(final String channel, final PremiumsResponseHandler handler) {
        String url = String.format("%s/channel/%s/premiums", getBaseUrl(), channel);

        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    PremiumsContainer value = objectMapper.readValue(content, PremiumsContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public final void getPremiums(final String channel, final RequestParams params, final PremiumsResponseHandler handler) {
        String url = String.format("%s/channel/%s/premiums", getBaseUrl(), channel);

        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    PremiumsContainer value = objectMapper.readValue(content, PremiumsContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public final void getSubscribers(final String channel, final SubscriberResponseHandler handler) {
        String url = String.format("%s/channel/%s/subscribers", getBaseUrl(), channel);


        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    SubscrurersContainer value = objectMapper.readValue(content, SubscrurersContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }

    public final void getSubscribers(final String channel, final RequestParams params, final SubscriberResponseHandler handler) {
        String url = String.format("%s/channel/%s/subscribers", getBaseUrl(), channel);


        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    SubscrurersContainer value = objectMapper.readValue(content, SubscrurersContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
    }
}
