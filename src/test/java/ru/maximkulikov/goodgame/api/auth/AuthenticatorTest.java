package ru.maximkulikov.goodgame.api.auth;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Test;
import ru.maximkulikov.goodgame.api.GoodGameTest;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 26.12.2017
 */
public class AuthenticatorTest {

   // @Test
    public void awaitAutorizationCode() {

        boolean actual = GoodGameTest.buildGGwithFakeIds().auth().awaitAutorizationCode();

        assertTrue(actual);
    }

    @Test
    public void authenticationUriTest() {

        try {
            URI callbackUri = new URI("http://127.0.0.1:23523/gg-authorize.html");
            String authuri = GoodGameTest.buildGGwithFakeIds().auth().getAuthenticationUrl(callbackUri, Scopes.CHAT_TOKEN);
            System.out.println(authuri);

            assertThat(authuri, is(notNullValue()));


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}