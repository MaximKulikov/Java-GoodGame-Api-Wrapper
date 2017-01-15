package ru.maximkulikov.goodgame.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import ru.maximkulikov.goodgame.api.auth.Authenticator;
import ru.maximkulikov.goodgame.api.models.AccessToken;
import ru.maximkulikov.goodgame.api.resources.*;


public class GoodGame {

    private static final String DEFAULT_BASE_URL = "http://api2.goodgame.ru";

    private static final String OLD_BASE_URL = "http://goodgame.ru/api";

    private static final int DEFAULT_API_VERSION = 2;

    // User's app client Id
    private String clientId;

    private String state;

    private Authenticator authenticator;

    private Map<StreamResources, AbstractResource> resources;


    public GoodGame(final String baseUrl, final int apiVersion) {
        this.authenticator = new Authenticator(baseUrl);
        // Instantiate resource connectors
        this.resources = new HashMap<>();
        this.resources.put(StreamResources.OAUTH, new OauthResource(baseUrl, apiVersion));
        this.resources.put(StreamResources.PLAYER, new PlayerResourses(baseUrl, apiVersion));
        this.resources.put(StreamResources.STREAMS, new StreamsResource(baseUrl, apiVersion));
        this.resources.put(StreamResources.CHANNELS, new ChannelsResource(baseUrl, apiVersion));
        this.resources.put(StreamResources.CHAT, new ChatResource(baseUrl, apiVersion));
        this.resources.put(StreamResources.GAMES, new GamesResource(baseUrl, apiVersion));
        this.resources.put(StreamResources.INFO, new InfoResource(baseUrl, apiVersion));
        this.resources.put(StreamResources.SMILES, new SmilesResource(baseUrl, apiVersion));
        this.resources.put(StreamResources.GITHUBAPI, new GithubResource(OLD_BASE_URL));
    }


    public GoodGame() {
        this(DEFAULT_BASE_URL, DEFAULT_API_VERSION);
    }


    public final Authenticator auth() {
        return this.authenticator;
    }

    public final ChannelsResource channels() {
        return (ChannelsResource) this.getResource(StreamResources.CHANNELS);
    }

    public final ChatResource chat() {
        return (ChatResource) this.getResource(StreamResources.CHAT);
    }

    public final GamesResource games() {
        return (GamesResource) this.getResource(StreamResources.GAMES);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
        // Update client id in all resources
        for (AbstractResource r : this.resources.values()) {
            r.setClientId(clientId);
        }
    }

    private AbstractResource getResource(StreamResources key) {
        AbstractResource r = this.resources.get(key);
        AccessToken accessToken = this.authenticator.getToken();
        if (accessToken != null) {
            r.setAccessToken(accessToken.getAccessToken());
        }

        return r;
    }

    public final String getState() {
        if (this.state == null) {
            this.state = UUID.randomUUID().toString();
        }
        return this.state;
    }

    public final GithubResource githubapi() {
        return (GithubResource) this.getResource(StreamResources.GITHUBAPI);
    }

    public final InfoResource info() {
        return (InfoResource) this.getResource(StreamResources.INFO);
    }

    public final OauthResource oauth() {
        return (OauthResource) this.getResource(StreamResources.OAUTH);
    }

    public final PlayerResourses player() {
        return (PlayerResourses) this.getResource(StreamResources.PLAYER);
    }

    public final SmilesResource smiles() {
        return (SmilesResource) this.getResource(StreamResources.SMILES);
    }

    public final StreamsResource streams() {
        return (StreamsResource) this.getResource(StreamResources.STREAMS);
    }

}
