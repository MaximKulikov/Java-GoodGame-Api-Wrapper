package ru.maximkulikov.goodgame.api.realization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.SmilesResponseHandler;
import ru.maximkulikov.goodgame.api.models.SmilesContainer;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 30.12.2017
 */
public class SmilesRealization {
    private static final Logger logger = LoggerFactory.getLogger(SmilesRealization.class);
    private GoodGame gg;

    public SmilesRealization(GoodGame gg) {
        this.gg = gg;
    }

    public SmilesContainer getChannelSmiles(final long channelID) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final SmilesContainer[] containerSuccess = new SmilesContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.smiles().getChannelSmiles(channelID, new SmilesResponseHandler() {
            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Channel smiles error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onSuccess(SmilesContainer smiles) {
                logger.info("Channel smiles success");
                containerSuccess[0] = smiles;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Channel smiles exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Channel smiles thread issue: {}", e.getLocalizedMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
        return getSmilesContainer(status, containerSuccess, containerFail, containerThrowable);
    }

    public SmilesContainer getChannelSmiles(final long channelId, final int page) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final SmilesContainer[] containerSuccess = new SmilesContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.smiles().getChannelSmiles(channelId, page, new SmilesResponseHandler() {
            @Override
            public void onSuccess(SmilesContainer smiles) {
                logger.info("Channel smiles success");
                containerSuccess[0] = smiles;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Channel smiles error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Channel smiles exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Channel smiles thread issue: {}", e.getLocalizedMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }

        return getSmilesContainer(status, containerSuccess, containerFail, containerThrowable);

    }

    public SmilesContainer getSmiles() throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final SmilesContainer[] containerSuccess = new SmilesContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.smiles().getSmiles(new SmilesResponseHandler() {
            @Override
            public void onSuccess(SmilesContainer smiles) {
                logger.info("Smiles success");
                containerSuccess[0] = smiles;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Smiles error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Smiles exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Smiles thread issue: {}", e.getLocalizedMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }

        return getSmilesContainer(status, containerSuccess, containerFail, containerThrowable);
    }

    public SmilesContainer getSmiles(final int page) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final SmilesContainer[] containerSuccess = new SmilesContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.smiles().getSmiles(page, new SmilesResponseHandler() {
            @Override
            public void onSuccess(SmilesContainer smiles) {
                logger.info("Smiles success");
                containerSuccess[0] = smiles;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Smiles error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Smiles exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Smiles thread issue: {}", e.getLocalizedMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
        return getSmilesContainer(status, containerSuccess, containerFail, containerThrowable);
    }

    private SmilesContainer getSmilesContainer(short[] status, SmilesContainer[] containerSuccess, String[] containerFail, Throwable[] containerThrowable) throws GoodGameError, GoodGameException {
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
