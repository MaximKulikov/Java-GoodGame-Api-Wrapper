package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.AjaxGamesHandler;
import ru.maximkulikov.goodgame.api.handlers.AjaxLoginResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.UpdateTitleResponseHandler;
import ru.maximkulikov.goodgame.api.models.AjaxGame;
import ru.maximkulikov.goodgame.api.models.AjaxLoginContainer;
import ru.maximkulikov.goodgame.api.models.UpdateTitle;

/**
 * {@link AjaxResource} предоставляет функциональность к ajax ресурсам.
 *
 * @author Maxim Kulikov
 * @since 02.04.2017
 */
public class AjaxResource extends AbstractResource {
    private static final Logger logger = LoggerFactory.getLogger(AjaxResource.class);
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded; charset=UTF-8";
    private static final String COOKIE = "Cookie";
    private static final String PARAMETERS_NULL = "{} parameters are null";
    private GoodGame gg;

    /**
     * Стандартный конструктор
     *
     * @param ajaxBaseUrl Базовая ссылка для доступа к ресурсу
     * @param gg          ссылка на текущий экземпляр объекта GoodGame
     */
    public AjaxResource(final String ajaxBaseUrl, final GoodGame gg) {
        super(ajaxBaseUrl);
        this.gg = gg;
    }

    /**
     * Поиск игры по части названия
     *
     * @param searchGame Фраза для поиска игры
     * @param handler
     */
    public final boolean games(final String searchGame, final AjaxGamesHandler handler) {
        if (searchGame == null) {
            logger.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
        String url = String.format("%s/games/all/", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("q", searchGame);

        http.removeHeader(CONTENT_TYPE);
        http.setHeader(CONTENT_TYPE, FORM_URL_ENCODED);
        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {

                content = content.replace("[[", "").replace("]]", "");
                String[] gameObject = content.split("],\\[");

                List<AjaxGame> ajaxGames = new ArrayList<>();

                for (String s : gameObject) {
                    s = s.replace("\",null,\"", "\",\"null\",\"");
                    s = s.substring(1, s.length() - 1);
                    String[] gameArray = s.split("\",\"");
                    ajaxGames.add(new AjaxGame(gameArray[0], gameArray[1], gameArray[gameArray.length - 1]));

                }
                handler.onSuccess(ajaxGames);
            }
        });
        return true;
    }

    /**
     * Поиск игр по названию, с дополнительными параметрами
     *
     * @param searchGame Фраза для поиска игры
     * @param params     Дополнительные параметры: genres (жанр), limit
     * @param handler
     */
    public final boolean games(final String searchGame, final RequestParams params, final AjaxGamesHandler handler) {
        if (searchGame == null || params == null) {
            logger.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }

        String url = String.format("%s/games/all/", getBaseUrl());
        params.put("q", searchGame);

        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {

                content = content.replace("[[", "").replace("]]", "");

                String[] gameObject = content.split("],\\[");

                List<AjaxGame> ajaxGames = new ArrayList<>();

                for (String s : gameObject) {
                    s = s.substring(1, s.length() - 1);
                    String[] gameArray = s.split("\",\"");
                    ajaxGames.add(new AjaxGame(gameArray[0], gameArray[1], gameArray[gameArray.length - 1]));

                }
                handler.onSuccess(ajaxGames);
            }
        });
        return true;
    }

    /**
     * Авторизация с использованием логина и пароля пользователя. В случает успеха, автоматически вызывает метод
     * GoodGame#setPhpSessId
     *
     * @param login    Логин
     * @param password Пароль
     * @param handler
     * @see GoodGame#setPhpSessId(String)
     */
    public final boolean login(final String login, final String password, final AjaxLoginResponseHandler handler) {
        if (login == null || password == null) {
            logger.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
        String url = String.format("%s/login/", getBaseUrl());

        RequestParams params = new RequestParams();

        params.put("login", login);
        params.put("password", password);
        params.put("remember", "1");
        params.put("return", "user");

        http.removeHeader(CONTENT_TYPE);
        http.removeHeader(COOKIE);
        http.setHeader(CONTENT_TYPE, FORM_URL_ENCODED);

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    AjaxLoginContainer value = objectMapper.readValue(content, AjaxLoginContainer.class);
                    String session = null;

                    if (headers.containsKey("Set-Cookie")) {
                        List<String> setCookies = headers.get("Set-Cookie");

                        for (String s : setCookies) {
                            if (s.contains("PHPSESSID=")) {
                                session = s;
                                gg.setPhpSessId(session);
                                value.setSession(session);
                            }
                        }
                    }
                    handler.onSuccess(value);
                } catch (IOException e) {
                    logger.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }

    /**
     * Изменение Заголовка и текущей игры трансляции
     *
     * @param channelId Канал, на котором нужно выполнить запрос
     * @param title     Новый заголовок трансляции
     * @param gameId    идентификатор игры
     * @param handler
     * @see #games(String, AjaxGamesHandler)
     */
    public final boolean updateTitle(final String channelId, final String title, final String gameId, final UpdateTitleResponseHandler handler) {
        if (channelId == null || title == null || gameId == null) {
            logger.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }

        String url = String.format("%s/channel/update-title/", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("objType", "7");
        params.put("objId", channelId);
        params.put("title", title);
        params.put("gameId", gameId);

        http.removeHeader(CONTENT_TYPE);
        http.removeHeader(COOKIE);
        http.setHeader(CONTENT_TYPE, FORM_URL_ENCODED);
        http.setHeader(COOKIE, this.gg.getPhpSessId());

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    UpdateTitle value = objectMapper.readValue(content, UpdateTitle.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    logger.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }
}
