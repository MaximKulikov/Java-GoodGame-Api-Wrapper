package ru.maximkulikov.goodgame.api.realization;

import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.PlayerResponseHandler;
import ru.maximkulikov.goodgame.api.models.Player;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 30.12.2017
 */
public class PlayerRealization {
    private GoodGame gg;

    public PlayerRealization(GoodGame gg) {
        this.gg = gg;
    }

    public Player getPlayer(final String channelId) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final Player[] containerSuccess = new Player[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.player().getPlayer(channelId, new PlayerResponseHandler() {
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
            public void onSuccess(Player player) {
                containerSuccess[0] = player;
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
}
