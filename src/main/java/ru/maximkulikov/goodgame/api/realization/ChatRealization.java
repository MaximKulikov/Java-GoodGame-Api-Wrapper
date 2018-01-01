package ru.maximkulikov.goodgame.api.realization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.ChatTokenResponseHandler;
import ru.maximkulikov.goodgame.api.models.ChatToken;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 30.12.2017
 */
public class ChatRealization {
    private static final Logger logger = LoggerFactory.getLogger(ChatRealization.class);
    private GoodGame gg;

    public ChatRealization(GoodGame gg) {
        this.gg = gg;
    }

    public ChatToken getChatToken() throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final ChatToken[] containerSuccess = new ChatToken[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.chat().getChatToken(new ChatTokenResponseHandler() {
            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Chat token error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Chat token exception: {}", throwable.getLocalizedMessage());
                containerThrowable[0] = throwable;
                status[0] = 3;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onSuccess(ChatToken chatToken) {
                logger.info("Chat token success");
                containerSuccess[0] = chatToken;
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
                    logger.error("Chat token thread issue: {}", e.getLocalizedMessage());
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
