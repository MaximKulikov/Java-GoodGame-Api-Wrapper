package ru.maximkulikov.goodgame.api;

import ru.maximkulikov.goodgame.api.auth.Authenticator;
import ru.maximkulikov.goodgame.api.models.AccessToken;
import ru.maximkulikov.goodgame.api.resources.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Enables the ability to interact with the Twitch.tv REST API.
 *
 * @author Matthew Bell
 */
public class GoodGame {

    public static final String DEFAULT_BASE_URL = "http://api2.goodgame.ru";
    public static final String OLD_BASE_URL = "http://goodgame.ru/api";
    public static final int DEFAULT_API_VERSION = 2;

    private String clientId; // User's app client Id
    private String state = null;
    private Authenticator authenticator;
    private Map<String, AbstractResource> resources;

    /**
     * Constructs a GoodGame application instance with a set API base URL and API version number.
     *
     * @param baseUrl    the base URL of the GoodGame API
     * @param apiVersion the API version number to request
     */
    public GoodGame(String baseUrl, int apiVersion) {
        authenticator = new Authenticator(DEFAULT_BASE_URL);
        // Instantiate resource connectors
        resources = new HashMap<String, AbstractResource>();
        resources.put("oauth", new OauthResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("player", new PlayerResourses(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("streams", new StreamsResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("channels", new ChannelsResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("chat", new ChatResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("games", new GamesResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("info", new InfoResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("smiles", new SmilesResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("githubapi", new GithubResource(OLD_BASE_URL));


    }

    /**
     * Constructs a GoodGame application instance.
     */
    public GoodGame() {
        this(DEFAULT_BASE_URL, DEFAULT_API_VERSION);
    }



    public Authenticator auth() {
        return authenticator;
    }
    public OauthResource oauth() {return (OauthResource) getResource("oauth");}
    public PlayerResourses player() {return (PlayerResourses) getResource("player");}
    public StreamsResource streams() {return (StreamsResource) getResource("streams");}
    public ChannelsResource channels() {
        return (ChannelsResource) getResource("channels");
    }
    public ChatResource chat() {
        return (ChatResource) getResource("chat");
    }
    public GamesResource games() {
        return (GamesResource) getResource("games");
    }
    public InfoResource info() {
        return (InfoResource) getResource("info");
    }
    public SmilesResource smiles() {
        return (SmilesResource) getResource("smiles");
    }
    public GithubResource githubapi() {
        return (GithubResource) getResource("githubapi");
    }







    /**
     * Get the set GoodGame client ID.
     *
     * @return The GoodGame client ID
     */
    public String getClientId() {
        return clientId;
    }



    /**
     * Set the Twitch client ID. Register your application on Twitch.tv to retrieve
     * a client ID.
     * <p>Passed to authorization endpoints to identify your application.</p>
     *
     * @param clientId Twitch client ID
     */
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
            r.setAccessToken(accessToken.getAccess_token());
        }

        return r;
    }

    public String getState() {
        if (this.state == null) {
            this.state = UUID.randomUUID().toString();
        }
        return this.state;
    }

}
