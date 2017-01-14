package ru.maximkulikov.goodgame.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import ru.maximkulikov.goodgame.api.auth.Authenticator;
import ru.maximkulikov.goodgame.api.models.AccessToken;
import ru.maximkulikov.goodgame.api.resources.*;


public class GoodGame {

    public static final String DEFAULT_BASE_URL = "http://api2.goodgame.ru";

    public static final String OLD_BASE_URL = "http://goodgame.ru/api";

    public static final int DEFAULT_API_VERSION = 2;

    // Initiate Keys
    private static final String OAUTH = "oauth";

    private static final String PLAYER = "player";

    private static final String STREAMS = "streams";

    private static final String CHANNELS = "channels";

    private static final String CHAT = "chat";

    private static final String GAMES = "games";

    private static final String INFO = "info";

    private static final String SMILES = "smiles";

    private static final String GITHUBAPI = "githubapi";

    // User's app client Id
    private String clientId;

    private String state = null;

    private Authenticator authenticator;

    private Map<String, AbstractResource> resources;


    public GoodGame(final String baseUrl, final int apiVersion) {
        this.authenticator = new Authenticator(baseUrl);
        // Instantiate resource connectors
        this.resources = new HashMap<String, AbstractResource>();
        this.resources.put(OAUTH, new OauthResource(baseUrl, apiVersion));
        this.resources.put(PLAYER, new PlayerResourses(baseUrl, apiVersion));
        this.resources.put(STREAMS, new StreamsResource(baseUrl, apiVersion));
        this.resources.put(CHANNELS, new ChannelsResource(baseUrl, apiVersion));
        this.resources.put(CHAT, new ChatResource(baseUrl, apiVersion));
        this.resources.put(GAMES, new GamesResource(baseUrl, apiVersion));
        this.resources.put(INFO, new InfoResource(baseUrl, apiVersion));
        this.resources.put(SMILES, new SmilesResource(baseUrl, apiVersion));
        this.resources.put(GITHUBAPI, new GithubResource(OLD_BASE_URL));
    }


    public GoodGame() {
        this(DEFAULT_BASE_URL, DEFAULT_API_VERSION);
    }


    public Authenticator auth() {
        return authenticator;
    }

    public ChannelsResource channels() {
        return (ChannelsResource) getResource(CHANNELS);
    }

    public ChatResource chat() {
        return (ChatResource) getResource(CHAT);
    }

    public GamesResource games() {
        return (GamesResource) getResource(GAMES);
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

    private AbstractResource getResource(String key) {
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

    public final  GithubResource githubapi() {
        return (GithubResource) getResource(GITHUBAPI);
    }

    public final  InfoResource info() {
        return (InfoResource) getResource(INFO);
    }

    public final  OauthResource oauth() {
        return (OauthResource) getResource(OAUTH);
    }

    public final PlayerResourses player() {
        return (PlayerResourses) getResource(PLAYER);
    }

    public final  SmilesResource smiles() {
        return (SmilesResource) getResource(SMILES);
    }

    public final  StreamsResource streams() {
        return (StreamsResource) getResource(STREAMS);
    }

}
