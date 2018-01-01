package ru.maximkulikov.goodgame.api.realization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.InfoResponseHandler;
import ru.maximkulikov.goodgame.api.models.Info;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 30.12.2017
 */
public class InfoRealization {
    private static final Logger logger = LoggerFactory.getLogger(InfoRealization.class);
    private GoodGame gg;

    public InfoRealization(GoodGame gg) {
        this.gg = gg;
    }

    public Info getInfo() throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final Info[] containerSuccess = new Info[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.info().getInfo(new InfoResponseHandler() {
            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Info error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Info exception: {}", throwable.getLocalizedMessage());
                containerThrowable[0] = throwable;
                status[0] = 3;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onSuccess(Info info) {
                logger.info("Info success");
                containerSuccess[0] = info;
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
                    logger.error("Info thread issue: {}", e.getLocalizedMessage());
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
