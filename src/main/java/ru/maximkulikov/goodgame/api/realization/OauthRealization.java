package ru.maximkulikov.goodgame.api.realization;

import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.OauthResourceResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.OauthResponseHandler;
import ru.maximkulikov.goodgame.api.models.AccessToken;
import ru.maximkulikov.goodgame.api.models.OauthResourceCheck;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 25.12.2017
 */
public class OauthRealization {

    private GoodGame gg;

    public OauthRealization(GoodGame gg) {
        this.gg = gg;
    }

    /**
     * Получение токена доступа. При удачном выполнении токен запоминается в системе и в последующих запросах используется автоматически
     *
     * @param useAutorizationCode Если требуется использовать Authorisation Code - true, если Refresh Token - false
     * @return
     * @throws GoodGameError     Ответ от GoodGame о неуспешном запросе (например, неправильный пароль)
     * @throws GoodGameException Ошибка при выполнении запроса к GoodGame (например, отсутсвует интернет)
     * @see ru.maximkulikov.goodgame.api.resources.OauthResource#getAccessToken(boolean, OauthResponseHandler)
     */
    public AccessToken getAccessToken(final boolean useAutorizationCode) throws GoodGameError, GoodGameException {

        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final AccessToken[] containerSuccess = new AccessToken[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];


        boolean result = gg.oauth().getAccessToken(useAutorizationCode, new OauthResponseHandler() {

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {

                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onSuccess(AccessToken accessToken) {
                containerSuccess[0] = accessToken;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                containerThrowable[0] = throwable;
                status[0] = 3;
                synchronized (o) {
                    o.notifyAll();
                }
            }


        });

        if (!result) {
            status[0] = 2;
            containerFail[0] = "Some internal error";
        }

        synchronized (o) {
            while (status[0] == 0) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        switch (status[0]) {
            case 1:
                return containerSuccess[0];

            case 2:
                throw new GoodGameError(containerFail[0]);

            case 3:
                throw new GoodGameException(containerThrowable[0]);
        }

        return null;
    }

    /**
     * Метод можно использовать для проверки возможности отправки запросов от имени пользователя с использованием токена
     *
     * @return
     * @throws GoodGameError     Ответ от GoodGame о неуспешном запросе (например, неправильный пароль)
     * @throws GoodGameException Ошибка при выполнении запроса к GoodGame (например, отсутсвует интернет)
     * @see ru.maximkulikov.goodgame.api.resources.OauthResource#getResource(OauthResourceResponseHandler)
     */
    public OauthResourceCheck getResource() throws GoodGameError, GoodGameException {

        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final OauthResourceCheck[] containerSuccess = new OauthResourceCheck[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        gg.oauth().getResource(new OauthResourceResponseHandler() {
            @Override
            public void onSuccess(OauthResourceCheck resource) {
                containerSuccess[0] = resource;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                containerThrowable[0] = throwable;
                status[0] = 3;
                synchronized (o) {
                    o.notifyAll();
                }
            }
        });

        synchronized (o) {
            while (status[0] == 0) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        switch (status[0]) {
            case 1:
                return containerSuccess[0];

            case 2:
                throw new GoodGameError(containerFail[0]);

            case 3:
                throw new GoodGameException(containerThrowable[0]);
        }

        return null;
    }

}
