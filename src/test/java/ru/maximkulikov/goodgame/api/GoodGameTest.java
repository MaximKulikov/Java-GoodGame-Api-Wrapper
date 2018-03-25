package ru.maximkulikov.goodgame.api;

import ru.maximkulikov.goodgame.api.auth.Scopes;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 06.06.2017.
 */
public class GoodGameTest {
    private static GoodGame gg = new GoodGame();


    static {
        gg.setClientId("123");
        gg.setClientSecret("456");
    }

    public static GoodGame getGg() {
        return gg;
    }

    public static GoodGame buildRealObject() {
        GoodGame gg = new GoodGame();
        gg.setClientId(SecretValue.GOODGAME_Client_ID);
        gg.setClientSecret(SecretValue.GOODGAME_SECRET_AUTH);
        gg.auth().getAuthenticationUrl(SecretValue.calback, Scopes.CHAT_TOKEN);
        return gg;
    }

    public static GoodGame buildGGwithFakeIds() {

        GoodGame gg = new GoodGame();
        gg.setClientId("123");
        gg.setClientSecret("456");

        return gg;
    }
}
