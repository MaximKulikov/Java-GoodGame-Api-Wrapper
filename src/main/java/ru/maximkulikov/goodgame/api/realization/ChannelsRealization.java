package ru.maximkulikov.goodgame.api.realization;

import com.mb3364.http.RequestParams;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.DonationsResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.PremiumsResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.SubscriberResponseHandler;
import ru.maximkulikov.goodgame.api.models.DonationsContainer;
import ru.maximkulikov.goodgame.api.models.PremiumsContainer;
import ru.maximkulikov.goodgame.api.models.SubscrurersContainer;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 30.12.2017
 */
public class ChannelsRealization {
    private GoodGame gg;

    public ChannelsRealization(GoodGame gg) {
        this.gg = gg;
    }

    public DonationsContainer getDonations(final String channel) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final DonationsContainer[] containerSuccess = new DonationsContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.channels().getDonations(channel, new DonationsResponseHandler() {
            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onSuccess(DonationsContainer donations) {
                containerSuccess[0] = donations;
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

        return getDonationsContainer(status, containerSuccess, containerFail, containerThrowable);
    }

    public DonationsContainer getDonations(final String channel, final RequestParams params) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final DonationsContainer[] containerSuccess = new DonationsContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.channels().getDonations(channel, params, new DonationsResponseHandler() {
            @Override
            public void onSuccess(DonationsContainer donations) {
                containerSuccess[0] = donations;
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

        return getDonationsContainer(status, containerSuccess, containerFail, containerThrowable);

    }

    private DonationsContainer getDonationsContainer(short[] status, DonationsContainer[] containerSuccess, String[] containerFail, Throwable[] containerThrowable) throws GoodGameError, GoodGameException {
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

    public PremiumsContainer getPremiums(final String channel) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final PremiumsContainer[] containerSuccess = new PremiumsContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.channels().getPremiums(channel, new PremiumsResponseHandler() {
            @Override
            public void onSuccess(PremiumsContainer premiums) {
                containerSuccess[0] = premiums;
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

        return getPremiumsContainer(status, containerSuccess, containerFail, containerThrowable);

    }

    private PremiumsContainer getPremiumsContainer(short[] status, PremiumsContainer[] containerSuccess, String[] containerFail, Throwable[] containerThrowable) throws GoodGameError, GoodGameException {
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

    public PremiumsContainer getPremiums(final String channel, final RequestParams params) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final PremiumsContainer[] containerSuccess = new PremiumsContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.channels().getPremiums(channel, params, new PremiumsResponseHandler() {
            @Override
            public void onSuccess(PremiumsContainer premiums) {
                containerSuccess[0] = premiums;
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

        return getPremiumsContainer(status, containerSuccess, containerFail, containerThrowable);

    }

    public SubscrurersContainer getSubscribers(final String channel) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final SubscrurersContainer[] containerSuccess = new SubscrurersContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.channels().getSubscribers(channel, new SubscriberResponseHandler() {
            @Override
            public void onSuccess(SubscrurersContainer subscribers) {
                containerSuccess[0] = subscribers;
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

        return getSubscrurersContainer(status, containerSuccess, containerFail, containerThrowable);

    }

    private SubscrurersContainer getSubscrurersContainer(short[] status, SubscrurersContainer[] containerSuccess, String[] containerFail, Throwable[] containerThrowable) throws GoodGameError, GoodGameException {
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

    public SubscrurersContainer getSubscribers(final String channel, final RequestParams params) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final SubscrurersContainer[] containerSuccess = new SubscrurersContainer[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.channels().getSubscribers(channel, params, new SubscriberResponseHandler() {
            @Override
            public void onSuccess(SubscrurersContainer subscribers) {
                containerSuccess[0] = subscribers;
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

        return getSubscrurersContainer(status, containerSuccess, containerFail, containerThrowable);


    }

}
