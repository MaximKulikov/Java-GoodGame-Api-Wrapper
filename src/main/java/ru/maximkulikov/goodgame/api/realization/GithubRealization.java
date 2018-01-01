package ru.maximkulikov.goodgame.api.realization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.GoodGame;
import ru.maximkulikov.goodgame.api.handlers.GitHubChannelSubscribersResponseHandler;
import ru.maximkulikov.goodgame.api.handlers.GitHubSharedHandler;
import ru.maximkulikov.goodgame.api.handlers.GitHubTokenHandler;
import ru.maximkulikov.goodgame.api.models.GitHubSubscribers;
import ru.maximkulikov.goodgame.api.models.GitHubToken;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 30.12.2017
 */
public class GithubRealization {
    private static final Logger logger = LoggerFactory.getLogger(GamesRealization.class);
    private GoodGame gg;

    public GithubRealization(GoodGame gg) {
        this.gg = gg;
    }

    public String getChannelStatus(final String channelId) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final String[] containerSuccess = new String[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.githubapi().getChannelStatus(channelId, new GitHubSharedHandler() {
            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Channel status error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onSuccess(String content) {
                logger.info("Channel status success");
                containerSuccess[0] = content;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Channel status exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Channel status thread issue: {}", e.getLocalizedMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }

        return getString(status, containerSuccess, containerFail, containerThrowable);
    }

    public GitHubSubscribers getChannelSubscribers() throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final GitHubSubscribers[] containerSuccess = new GitHubSubscribers[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.githubapi().getChannelSubscribers(new GitHubChannelSubscribersResponseHandler() {
            @Override
            public void onSuccess(GitHubSubscribers gitHubSubscribers) {
                logger.info("Channel subscribers success");
                containerSuccess[0] = gitHubSubscribers;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Channel subscribers error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Channel subscribers exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Channel subscribers thread issue: {}", e.getLocalizedMessage());
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

    public String getChannelsByGame(final String gameUrl) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final String[] containerSuccess = new String[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];

        boolean result = gg.githubapi().getChannelsByGame(gameUrl, new GitHubSharedHandler() {
            @Override
            public void onSuccess(String content) {
                logger.info("Channels by name success");
                containerSuccess[0] = content;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Channels by name error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Channels by name exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Channels by name thread issue: {}", e.getLocalizedMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }

        return getString(status, containerSuccess, containerFail, containerThrowable);

    }

    public String getGgChannelStatus(final String id) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final String[] containerSuccess = new String[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.githubapi().getGgChannelStatus(id, new GitHubSharedHandler() {
            @Override
            public void onSuccess(String content) {
                logger.info("Channel status success");
                containerSuccess[0] = content;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Channel status error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Channel status exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Channel status thread issue: {}", e.getLocalizedMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
        return getString(status, containerSuccess, containerFail, containerThrowable);
    }

    private String getString(short[] status, String[] containerSuccess, String[] containerFail, Throwable[] containerThrowable) throws GoodGameError, GoodGameException {
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

    public GitHubToken getToken(final String username, final String password) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final GitHubToken[] containerSuccess = new GitHubToken[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.githubapi().getToken(username, password, new GitHubTokenHandler() {
            @Override
            public void onSuccess(GitHubToken token) {
                logger.info("Token success");
                containerSuccess[0] = token;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Token error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Token exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Token thread issue: {}", e.getLocalizedMessage());
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

    public String getUpcomingBroadcast(final String id) throws GoodGameError, GoodGameException {
        final Object o = new Object();
        /**
         *  status 0 = lock
         *  status 1 = success
         *  status 2 = fail
         *  status 3 = throw
         */
        final short[] status = {0};
        final String[] containerSuccess = new String[1];
        final String[] containerFail = new String[1];
        final Throwable[] containerThrowable = new Throwable[1];
        boolean result = gg.githubapi().getUpcomingBroadcast(id, new GitHubSharedHandler() {
            @Override
            public void onSuccess(String content) {
                logger.info("Upcoming broadcast success");
                containerSuccess[0] = content;
                status[0] = 1;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                logger.error("Upcoming broadcast error {}: {}. {}", statusCode, statusMessage, errorMessage);
                containerFail[0] = String.valueOf(statusCode) + ": " + statusMessage + "(" + errorMessage + ")";
                status[0] = 2;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Upcoming broadcast exception: {}", throwable.getLocalizedMessage());
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
                    logger.error("Upcoming broadcast thread issue: {}", e.getLocalizedMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }

        return getString(status, containerSuccess, containerFail, containerThrowable);
    }
}
