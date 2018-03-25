package ru.maximkulikov.goodgame.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import ru.maximkulikov.goodgame.api.handlers.AjaxLoginResponseHandler;
import ru.maximkulikov.goodgame.api.models.AjaxLoginContainer;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 06.06.2017.
 */
public class AjaxRosourceTest {
    private static final GoodGame gg = GoodGameTest.getGg();

    @Test
    public void loginTest() {

        final Object o = new Object();
        final boolean[] lock = new boolean[1];
        lock[0] = false;
        final AjaxLoginContainer[] container = new AjaxLoginContainer[1];


        gg.ajax().login(SecretValue.GOODGAME_LOGIN, SecretValue.GOODGAME_PASSWORD, new AjaxLoginResponseHandler() {
            @Override
            public void onSuccess(AjaxLoginContainer ajaxLoginContainer) {
                container[0] = ajaxLoginContainer;
                lock[0] = true;
                synchronized (o) {
                    o.notifyAll();
                }
            }

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



        assertEquals(true, container[0].getResult());
        assertEquals("Вы успешно вошли на сайт", container[0].getResponse());
        assertEquals(4, container[0].getCode().intValue());
        assertEquals("366601", container[0].getAjaxReturn().getId());
        assertEquals("Trinion", container[0].getAjaxReturn().getUsername());
        assertEquals("36229", container[0].getAjaxReturn().getChannel().getId());
        assertEquals("https://goodgame.ru/channel/Trinion/", container[0].getAjaxReturn().getChannel().getLink());




    }
}
