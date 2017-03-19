package ru.maximkulikov.goodgame.api;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import ru.maximkulikov.goodgame.api.auth.Authenticator;
import ru.maximkulikov.goodgame.api.resources.*;


public class GoodGame {

    private static final String DEFAULT_BASE_URL = "http://api2.goodgame.ru";

    private static final String OLD_BASE_URL = "http://goodgame.ru/api";

    private static final int DEFAULT_API_VERSION = 2;

    // User's app client Id
    private String clientId;

    private String clientSecret;

    private String state;

    private Authenticator authenticator;

    private Map<Resources, AbstractResource> resources;


    public GoodGame(final String baseUrl, final int apiVersion) {
        this.authenticator = new Authenticator(baseUrl);
        // Instantiate resource connectors
        this.resources = new HashMap<>();
        this.resources.put(Resources.OAUTH, new OauthResource(baseUrl, apiVersion, this));
        this.resources.put(Resources.PLAYER, new PlayerResourses(baseUrl, apiVersion));
        this.resources.put(Resources.STREAMS, new StreamsResource(baseUrl, apiVersion));
        this.resources.put(Resources.CHANNELS, new ChannelsResource(baseUrl, apiVersion));
        this.resources.put(Resources.CHAT, new ChatResource(baseUrl, apiVersion));
        this.resources.put(Resources.GAMES, new GamesResource(baseUrl, apiVersion));
        this.resources.put(Resources.INFO, new InfoResource(baseUrl, apiVersion));
        this.resources.put(Resources.SMILES, new SmilesResource(baseUrl, apiVersion));
        this.resources.put(Resources.GITHUBAPI, new GithubResource(OLD_BASE_URL));
    }


    public GoodGame() {
        this(DEFAULT_BASE_URL, DEFAULT_API_VERSION);
    }


    public final Authenticator auth() {
        return this.authenticator;
    }

    public final ChannelsResource channels() {
        return (ChannelsResource) this.getResource(Resources.CHANNELS);
    }

    public final ChatResource chat() {
        return (ChatResource) this.getResource(Resources.CHAT);
    }

    public final GamesResource games() {
        return (GamesResource) this.getResource(Resources.GAMES);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final void setClientId(final String clientId) {
        this.clientId = clientId;
        // Update client id in all resources
        for (AbstractResource r : this.resources.values()) {
            r.setClientId(clientId);
        }
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final void setClientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public final URI getRedirectUri() {
        return this.authenticator.getRedirectUri();
    }

    private AbstractResource getResource(final Resources key) {
        AbstractResource r = this.resources.get(key);

        String accessToken = this.authenticator.getAccessToken();

        if (accessToken != null) {
            r.setAccessToken(accessToken);
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
        return (GithubResource) this.getResource(Resources.GITHUBAPI);
    }

    public final InfoResource info() {
        return (InfoResource) this.getResource(Resources.INFO);
    }

    public final OauthResource oauth() {
        return (OauthResource) this.getResource(Resources.OAUTH);
    }

    public final PlayerResourses player() {
        return (PlayerResourses) this.getResource(Resources.PLAYER);
    }

    public final SmilesResource smiles() {
        return (SmilesResource) this.getResource(Resources.SMILES);
    }

    public final StreamsResource streams() {
        return (StreamsResource) this.getResource(Resources.STREAMS);
    }

    public enum Resources {

        OAUTH("oauth"),
        PLAYER("player"),
        STREAMS("streams"),
        CHANNELS("channels"),
        CHAT("chat"),
        GAMES("games"),
        INFO("info"),
        SMILES("smiles"),
        GITHUBAPI("githubapi");

        Resources(final String key) {

        }
    }
}
