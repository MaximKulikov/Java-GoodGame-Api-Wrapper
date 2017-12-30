package ru.maximkulikov.goodgame.api.realization;

import java.util.ArrayList;
import java.util.List;
import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.AjaxGamesHandler;
import ru.maximkulikov.goodgame.api.handlers.AjaxLoginResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.UpdateTitleResponseHandler;
import ru.maximkulikov.goodgame.api.models.AjaxGame;
import ru.maximkulikov.goodgame.api.models.AjaxLoginContainer;
import ru.maximkulikov.goodgame.api.models.UpdateTitle;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 29.12.2017
 */
public class AjaxRealization {
    private GoodGame gg;

    public AjaxRealization(GoodGame gg) {

        this.gg = gg;
    }

    public List<AjaxGame> games(final String searchGame) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final List<AjaxGame>[] containerSuccess = new List[]{new ArrayList<>()};
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.ajax().games(searchGame, new AjaxGamesHandler() {
            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onSuccess(List<AjaxGame> ajaxGames) {
                containerSuccess[0] = ajaxGames;
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
                    Thread.currentThread().interrupt();
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
            default:
                return null;
        }

    }

    public List<AjaxGame> games(final String searchGame, final RequestParams params) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final List<AjaxGame>[] containerSuccess = new List[]{new ArrayList<>()};
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.ajax().games(searchGame, params, new AjaxGamesHandler() {
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

            @Override
            public void onSuccess(List<AjaxGame> ajaxGames) {
                containerSuccess[0] = ajaxGames;
                status[0] = 1;
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
                    Thread.currentThread().interrupt();
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
            default:
                return null;
        }

    }

    public AjaxLoginContainer login(final String login, final String password) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final AjaxLoginContainer[] containerSuccess = new AjaxLoginContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.ajax().login(login, password, new AjaxLoginResponseHandler() {
            @Override
            public void onSuccess(AjaxLoginContainer ajaxLoginContainer) {
                containerSuccess[0] = ajaxLoginContainer;
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
                    Thread.currentThread().interrupt();
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
            default:
                return null;
        }


    }

    public UpdateTitle updateTitle(final String channelId, final String title, final String gameId) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final UpdateTitle[] containerSuccess = new UpdateTitle[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.ajax().updateTitle(channelId, title, gameId, new UpdateTitleResponseHandler() {
            @Override
            public void onSuccess(UpdateTitle updateTitle) {
                containerSuccess[0] = updateTitle;
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
                    Thread.currentThread().interrupt();
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
            default:
                return null;
        }

    }

}
