package ru.maximkulikov.goodgame.api.resources;

import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.AjaxGamesHandler;
import ru.maximkulikov.goodgame.api.handlers.AjaxLoginResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.UpdateTitleResponseHandler;
import ru.maximkulikov.goodgame.api.models.AjaxGame;
import ru.maximkulikov.goodgame.api.models.AjaxLoginContainer;
import ru.maximkulikov.goodgame.api.models.UpdateTitle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Класс для доступа к вызовам ajax ресурса
 *
 * @author Maxim Kulikov
 * @since 02.04.2017
 */
public class AjaxResource extends AbstractResource {

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
     * Изменение Заголовка и текущей игры трансляции
     *
     * @param channelId Канал, на котором нужно выполнить запрос
     * @param title     Новый заголовок трансляции
     * @param gameId    идентификатор игры
     * @param handler
     * @see #games(String, AjaxGamesHandler)
     */
    public final void updateTitle(final String channelId, final String title, final String gameId, final UpdateTitleResponseHandler handler) {
        String url = String.format("%s/channel/update-title/", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("objType", "7");
        params.put("objId", channelId);
        params.put("title", title);
        params.put("gameId", gameId);


        http.removeHeader("Content-Type");
        http.removeHeader("Cookie");
        http.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.setHeader("Cookie", this.gg.getPhpSessId());

        http.post(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    UpdateTitle value = objectMapper.readValue(content, UpdateTitle.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });
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
    public final void login(final String login, final String password, final AjaxLoginResponseHandler handler) {
        String url = String.format("%s/login/", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("login", login);
        params.put("password", password);
        params.put("remember", "1");
        params.put("return", "user");


        http.removeHeader("Content-Type");
        http.removeHeader("Cookie");
        http.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");


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
                            }


                        }
                    }

                    handler.onSuccess(value, session);
                } catch (IOException e) {
                    handler.onFailure(e);
                }
            }
        });

    }

    /**
     * Поиск игры по части названия
     *
     * @param searchGame Фраза для поиска игры
     * @param handler
     */
    public final void games(final String searchGame, final AjaxGamesHandler handler) {
        String url = String.format("%s/games/all/", getBaseUrl());

        RequestParams params = new RequestParams();
        params.put("q", searchGame);


        http.removeHeader("Content-Type");
        http.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                //                    content.substring(2,content.length()-2);
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
    }

    /**
     * Поиск игр по названию, с дополнительными параметрами
     *
     * @param searchGame Фраза для поиска игры
     * @param params     Дополнительные параметры: genres (жанр), limit
     * @param handler
     */
    public final void games(final String searchGame, final RequestParams params, final AjaxGamesHandler handler) {
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
    }
}
