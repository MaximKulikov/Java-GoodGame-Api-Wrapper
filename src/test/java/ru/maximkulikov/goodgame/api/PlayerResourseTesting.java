package ru.maximkulikov.goodgame.api;

import org.junit.Test;
import ru.maximkulikov.goodgame.api.handlers.PlayerResponseHandler;
import ru.maximkulikov.goodgame.api.models.Player;


import static org.junit.Assert.assertEquals;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 02.06.2017.
 */
public class PlayerResourseTesting {

    private static final GoodGame gg = GoodGameTest.getGg();

    private static final String CHANNELID = "36229";

    @Test
    public void getPlayerTest() {


        final Object o = new Object();

        final boolean[] lock = new boolean[1];
        lock[0] = false;

        final Player[] p = new Player[1];


        gg.player().getPlayer(CHANNELID, new PlayerResponseHandler() {
            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {

                lock[0] = true;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                lock[0] = true;
                synchronized (o) {
                    o.notifyAll();
                }
            }

            @Override
            public void onSuccess(Player player) {

                p[0] = player;

                lock[0] = true;
                synchronized (o) {
                    o.notifyAll();
                }

            }
        });

        synchronized (o) {
            while (!lock[0]) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        assertEquals("36229", p[0].getChannelId());
        assertEquals("Trinion", p[0].getChannelKey());
        assertEquals("1494338668", p[0].getChannelStart());



    }
}
