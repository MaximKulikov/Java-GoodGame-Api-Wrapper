package ru.maximkulikov.goodgame.api.realization;

import com.mb3364.http.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.StreamChannelResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.StreamsResponseHandler;
import ru.maximkulikov.goodgame.api.models.ChannelContainer;
import ru.maximkulikov.goodgame.api.models.EmbededChannels;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 30.12.2017
 */
public class StreamsRealization {
    private static final Logger logger = LoggerFactory.getLogger(StreamsRealization.class);
    private GoodGame gg;

    public StreamsRealization(GoodGame gg) {
        this.gg = gg;
    }

    public ChannelContainer getChannel(final String channel) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final ChannelContainer[] containerSuccess = new ChannelContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.streams().getChannel(channel, new StreamChannelResponseHandler() {
            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Channel error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onSuccess(ChannelContainer channel) {
                logger.info("Channel success");
                containerSuccess[0] = channel;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Channel exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Channel thread issue: {}", e.getLocalizedMessage());
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

    private EmbededChannels getEmbededChannels(short[] status, EmbededChannels[] containerSuccess, String[] containerFail, Throwable[] containerThrowable) throws GoodGameError, GoodGameException {
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

    public EmbededChannels getStreams() throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final EmbededChannels[] containerSuccess = new EmbededChannels[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.streams().getStreams(new StreamsResponseHandler() {
            @Override
            public void onSuccess(EmbededChannels channels) {
                logger.info("Streams success");
                containerSuccess[0] = channels;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Streams error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Streams exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Streams thread issue: {}", e.getLocalizedMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
        return getEmbededChannels(status, containerSuccess, containerFail, containerThrowable);
    }

    public EmbededChannels getStreams(final RequestParams param) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final EmbededChannels[] containerSuccess = new EmbededChannels[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.streams().getStreams(param, new StreamsResponseHandler() {
            @Override
            public void onSuccess(EmbededChannels channels) {
                logger.info("Streams success");
                containerSuccess[0] = channels;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Streams error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Streams exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Streams thread issue: {}", e.getLocalizedMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }

        return getEmbededChannels(status, containerSuccess, containerFail, containerThrowable);
    }
}
