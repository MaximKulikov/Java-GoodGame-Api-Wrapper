package com.mb3364.twitch.api;

import com.mb3364.twitch.api.auth.Authenticator;
import com.mb3364.twitch.api.models.AccessToken;
import com.mb3364.twitch.api.resources.*;

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







        resources.put("ingests", new IngestsResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("root", new RootResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("search", new SearchResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("teams", new TeamsResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("users", new UsersResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
        resources.put("videos", new VideosResource(DEFAULT_BASE_URL, DEFAULT_API_VERSION));
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

    /**
     * Get the {@link IngestsResource} object. The {@link IngestsResource} provides
     * the functionality to access the <code>/ingests</code> endpoints of the Twitch API.
     *
     * @return the {@link IngestsResource} object
     * @see ChannelsResource
     * @see ChatResource
     * @see GamesResource
     * @see IngestsResource
     * @see RootResource
     * @see SearchResource
     * @see StreamsResource
     * @see TeamsResource
     * @see UsersResource
     * @see VideosResource
     */
    public IngestsResource ingests() {
        return (IngestsResource) getResource("ingests");
    }

    /**
     * Get the {@link RootResource} object. The {@link RootResource} provides
     * the functionality to access the root <code>/</code> endpoints of the Twitch API.
     *
     * @return the {@link RootResource} object
     * @see ChannelsResource
     * @see ChatResource
     * @see GamesResource
     * @see IngestsResource
     * @see RootResource
     * @see SearchResource
     * @see StreamsResource
     * @see TeamsResource
     * @see UsersResource
     * @see VideosResource
     */
    public RootResource root() {
        return (RootResource) getResource("root");
    }

    /**
     * Get the {@link SearchResource} object. The {@link SearchResource} provides
     * the functionality to access the <code>/search</code> endpoints of the Twitch API.
     *
     * @return the {@link SearchResource} object
     * @see ChannelsResource
     * @see ChatResource
     * @see GamesResource
     * @see IngestsResource
     * @see RootResource
     * @see SearchResource
     * @see StreamsResource
     * @see TeamsResource
     * @see UsersResource
     * @see VideosResource
     */
    public SearchResource search() {
        return (SearchResource) getResource("search");
    }

    /**
     * Get the {@link StreamsResource} object. The {@link StreamsResource} provides
     * the functionality to access the <code>/streams</code> endpoints of the Twitch API.
     *
     * @return the {@link StreamsResource} object
     * @see ChannelsResource
     * @see ChatResource
     * @see GamesResource
     * @see IngestsResource
     * @see RootResource
     * @see SearchResource
     * @see StreamsResource
     * @see TeamsResource
     * @see UsersResource
     * @see VideosResource
     */
    public StreamsResource streams() {
        return (StreamsResource) getResource("streams");
    }

    /**
     * Get the {@link TeamsResource} object. The {@link TeamsResource} provides
     * the functionality to access the <code>/teams</code> endpoints of the Twitch API.
     *
     * @return the {@link TeamsResource} object
     * @see ChannelsResource
     * @see ChatResource
     * @see GamesResource
     * @see IngestsResource
     * @see RootResource
     * @see SearchResource
     * @see StreamsResource
     * @see TeamsResource
     * @see UsersResource
     * @see VideosResource
     */
    public TeamsResource teams() {
        return (TeamsResource) getResource("teams");
    }

    /**
     * Get the {@link UsersResource} object. The {@link UsersResource} provides
     * the functionality to access the <code>/users</code> endpoints of the Twitch API.
     *
     * @return the {@link UsersResource} object
     * @see ChannelsResource
     * @see ChatResource
     * @see GamesResource
     * @see IngestsResource
     * @see RootResource
     * @see SearchResource
     * @see StreamsResource
     * @see TeamsResource
     * @see UsersResource
     * @see VideosResource
     */
    public UsersResource users() {
        return (UsersResource) getResource("users");
    }

    /**
     * Get the {@link VideosResource} object. The {@link VideosResource} provides
     * the functionality to access the <code>/videos</code> endpoints of the Twitch API.
     *
     * @return the {@link VideosResource} object
     * @see ChannelsResource
     * @see ChatResource
     * @see GamesResource
     * @see IngestsResource
     * @see RootResource
     * @see SearchResource
     * @see StreamsResource
     * @see TeamsResource
     * @see UsersResource
     * @see VideosResource
     */
    public VideosResource videos() {
        return (VideosResource) getResource("videos");
    }
}
