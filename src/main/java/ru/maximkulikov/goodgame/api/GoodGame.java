package ru.maximkulikov.goodgame.api;

import ru.maximkulikov.goodgame.api.auth.Authenticator;
import ru.maximkulikov.goodgame.api.handlers.AjaxLoginResponseHandler;
import ru.maximkulikov.goodgame.api.resources.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Ключевой класс библиотеки для работы со стриминговым сервисов, содержит часть авторизационных данных и ресурсы.
 * Создайте экземпляр объекта для работы. <br><br> P.S.: Возможна путаница с классом Authenticator, т.к. он тоже
 * содержит в себе некоторые параметры для подключения.
 */
public class GoodGame {

    private static final String DEFAULT_BASE_URL = "http://api2.goodgame.ru";

    private static final String OLD_BASE_URL = "http://goodgame.ru/api";

    private static final String AJAX_BASE_URL = "http://goodgame.ru/ajax";

    private static final int DEFAULT_API_VERSION = 2;

    private String clientId;

    private String clientSecret;

    private String state;

    private Authenticator authenticator;

    private Map<Resources, AbstractResource> resources;

    private String phpSessId;

    public final String getPhpSessId() {
        return this.phpSessId;
    }

    /**
     * Конструктор с параметрами
     *
     * @param baseUrl    Ссылка для работы с API. Работает для всех ресурсов, кроме github и ajax.
     * @param apiVersion Версия API. Работает для всех ресурсов, кроме github и ajax.
     */
    public GoodGame(final String baseUrl, final int apiVersion) {
        this.authenticator = new Authenticator(baseUrl);
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
        this.resources.put(Resources.AJAX, new AjaxResource(AJAX_BASE_URL, this));
    }

    /**
     * Конструктор с параметрами по умолчанию. DEFAULT_BASE_URL = "http://api2.goodgame.ru", DEFAULT_API_VERSION = 2
     */
    public GoodGame() {
        this(DEFAULT_BASE_URL, DEFAULT_API_VERSION);
    }

    /**
     * @return Ресурс AjaxResource
     * @see AjaxResource
     */
    public final AjaxResource ajax() {
        return (AjaxResource) this.getResource(Resources.AJAX);
    }

    /**
     * @return Ресурс Authenticator
     * @see Authenticator
     */
    public final Authenticator auth() {
        return this.authenticator;
    }

    /**
     * @return Ресурс ChannelsResource
     * @see ChannelsResource
     */
    public final ChannelsResource channels() {
        return (ChannelsResource) this.getResource(Resources.CHANNELS);
    }

    /**
     * @return Ресурс ChatResource
     * @see ChatResource
     */
    public final ChatResource chat() {
        return (ChatResource) this.getResource(Resources.CHAT);
    }

    /**
     * @return Ресурс GamesResource
     * @see GamesResource
     */
    public final GamesResource games() {
        return (GamesResource) this.getResource(Resources.GAMES);
    }

    /**
     * @return Возвращает String значение ИД приложения, зарегистрированного как oauth приложение на сайте Goodgame
     */
    public final String getClientId() {
        return this.clientId;
    }

    /**
     * @param clientId Установка String значения ИД приложения, зарегистрированного как oauth приложение на сайте
     *                 Goodgame. Используется при oauth авторизации, не требующей пароля пользователя
     */
    public final void setClientId(final String clientId) {
        this.clientId = clientId;
        // Update client id in all resources
        for (AbstractResource r : this.resources.values()) {
            r.setClientId(clientId);
        }
    }

    /**
     * @return Возвращает String значение Client Secret для зарагистрированного oauth приложения.
     */
    public final String getClientSecret() {
        return this.clientSecret;
    }

    /**
     * @param clientSecret Установка String значения Client Secret для зарагистрированного oauth приложения.
     *                     Используется при oauth авторизации, не требующей пароля пользователя
     */
    public final void setClientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * @return Возвращает ссылку для перенаправления пользователя на страницу авторизации. Используется при oauth
     * авторизации, не требующей пароля пользователя.
     * @see Authenticator#getRedirectUri()
     */
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

    /**
     * @return Возвращает уникальное значение (UUID), которое GoodGame рекомендует передавать с запросом авторизации.
     * Сайт должен вернуть с ответом это же значение.
     */
    public final String getState() {
        if (this.state == null) {
            this.state = UUID.randomUUID().toString();
        }
        return this.state;
    }

    /**
     * @return Ресурс GithubResource
     * @see GithubResource
     */
    public final GithubResource githubapi() {
        return (GithubResource) this.getResource(Resources.GITHUBAPI);
    }

    /**
     * @return Ресурс InfoResource
     * @see InfoResource
     */
    public final InfoResource info() {
        return (InfoResource) this.getResource(Resources.INFO);
    }

    /**
     * @return Ресурс OauthResource
     * @see OauthResource
     */
    public final OauthResource oauth() {
        return (OauthResource) this.getResource(Resources.OAUTH);
    }

    /**
     * @return Ресурс PlayerResourses
     * @see PlayerResourses
     */
    public final PlayerResourses player() {
        return (PlayerResourses) this.getResource(Resources.PLAYER);
    }

    /**
     * @param phpSessId Установка значения Сессии из Cookies ответа. Используется в некоторых запросах ajax
     * @see AjaxResource#login(String, String, AjaxLoginResponseHandler)
     */
    public final void setPhpSessId(final String phpSessId) {
        this.phpSessId = phpSessId;
    }

    /**
     * @return Ресурс SmilesResource
     * @see SmilesResource
     */
    public final SmilesResource smiles() {
        return (SmilesResource) this.getResource(Resources.SMILES);
    }

    /**
     * @return Ресурс StreamsResource
     * @see StreamsResource
     */
    public final StreamsResource streams() {
        return (StreamsResource) this.getResource(Resources.STREAMS);
    }

    /**
     * Перечисление всех Ресурсов GoodGame
     */
    public enum Resources {

        AJAX("ajax"),
        OAUTH("oauth"),
        PLAYER("player"),
        STREAMS("streams"),
        CHANNELS("channels"),
        CHAT("chat"),
        GAMES("games"),
        INFO("info"),
        SMILES("smiles"),
        GITHUBAPI("githubapi");

        /**
         * Стандартный Конструктор, при использовании ключа
         *
         * @param key
         */
        Resources(final String key) {

        }
    }
}
