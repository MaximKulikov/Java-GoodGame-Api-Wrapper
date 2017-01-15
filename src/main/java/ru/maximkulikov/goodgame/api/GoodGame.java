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

    private String state = null;

    private Authenticator authenticator;

    private Map<StreamResourses, AbstractResource> resources;


    public GoodGame(final String baseUrl, final int apiVersion) {
        this.authenticator = new Authenticator(baseUrl);
        // Instantiate resource connectors
        this.resources = new HashMap<>();
        this.resources.put(StreamResourses.OAUTH, new OauthResource(baseUrl, apiVersion));
        this.resources.put(StreamResourses.PLAYER, new PlayerResourses(baseUrl, apiVersion));
        this.resources.put(StreamResourses.STREAMS, new StreamsResource(baseUrl, apiVersion));
        this.resources.put(StreamResourses.CHANNELS, new ChannelsResource(baseUrl, apiVersion));
        this.resources.put(StreamResourses.CHAT, new ChatResource(baseUrl, apiVersion));
        this.resources.put(StreamResourses.GAMES, new GamesResource(baseUrl, apiVersion));
        this.resources.put(StreamResourses.INFO, new InfoResource(baseUrl, apiVersion));
        this.resources.put(StreamResourses.SMILES, new SmilesResource(baseUrl, apiVersion));
        this.resources.put(StreamResourses.GITHUBAPI, new GithubResource(OLD_BASE_URL));
    }


    public GoodGame() {
        this(DEFAULT_BASE_URL, DEFAULT_API_VERSION);
    }


    public Authenticator auth() {
        return this.authenticator;
    }

    public ChannelsResource channels() {
        return (ChannelsResource) getResource(StreamResourses.CHANNELS);
    }

    public ChatResource chat() {
        return (ChatResource) getResource(StreamResourses.CHAT);
    }

    public GamesResource games() {
        return (GamesResource) getResource(StreamResourses.GAMES);
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
        // Update client id in all resources
        for (AbstractResource r : resources.values()) {
            r.setClientId(clientId);
        }
    }

    private AbstractResource getResource(StreamResourses key) {
        AbstractResource r = resources.get(key);
        AccessToken accessToken = authenticator.getToken();
        if (accessToken != null) {
            r.setAccessToken(accessToken.getAccessToken());
        }

        return r;
    }

    public String getState() {
        if (this.state == null) {
            this.state = UUID.randomUUID().toString();
        }
        return this.state;
    }

    public final GithubResource githubapi() {
        return (GithubResource) getResource(StreamResourses.GITHUBAPI);
    }

    public final InfoResource info() {
        return (InfoResource) getResource(StreamResourses.INFO);
    }

    public final OauthResource oauth() {
        return (OauthResource) getResource(StreamResourses.OAUTH);
    }

    public final PlayerResourses player() {
        return (PlayerResourses) getResource(StreamResourses.PLAYER);
    }

    public final SmilesResource smiles() {
        return (SmilesResource) getResource(StreamResourses.SMILES);
    }

    public final StreamsResource streams() {
        return (StreamsResource) getResource(StreamResourses.STREAMS);
    }

}
