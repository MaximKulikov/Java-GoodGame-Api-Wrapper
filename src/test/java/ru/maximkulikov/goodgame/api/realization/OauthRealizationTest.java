package ru.maximkulikov.goodgame.api.realization;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.maximkulikov.goodgame.api.GoodGameImplementation;
import ru.maximkulikov.goodgame.api.GoodGameTest;
import ru.maximkulikov.goodgame.api.SecretValue;
import ru.maximkulikov.goodgame.api.models.AccessToken;
import ru.maximkulikov.goodgame.api.models.AjaxLoginContainer;
import ru.maximkulikov.goodgame.api.models.OauthResourceCheck;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 26.12.2017
 */

public class OauthRealizationTest {

    private OauthRealization oauthRealization = new OauthRealization(GoodGameTest.buildRealObject());;

    @After
    public void after() {
        this.oauthRealization = null;
    }

    @Before
    public void before() {
        this.oauthRealization = null;
    }


    @Test
    public void getResourceTest() {

        try {
            OauthResourceCheck orc = oauthRealization.getResource();
            System.out.println(orc);

        } catch (GoodGameError goodGameError) {
            goodGameError.printStackTrace();
        } catch (GoodGameException e) {
            e.printStackTrace();
        }

    }

  //  @Test
  public void getAccessTokenTest() {

      this.oauthRealization = new OauthRealization(GoodGameTest.buildRealObject());

      AccessToken actual = null;

      try {
          actual = oauthRealization.getAccessToken(true);
          assertThat(actual.getAccessToken(), is(SecretValue.ggAccessToken));
      } catch (GoodGameError goodGameError) {

          assertThat(goodGameError.getMessage(), is("Some internal error"));
      } catch (GoodGameException e) {

      }
  }

    @Test
    public void ajaxLoginTest() throws GoodGameError, GoodGameException {
        GoodGameImplementation ggi = new GoodGameImplementation(GoodGameTest.buildRealObject());
        String login = SecretValue.GOODGAME_LOGIN+"f";
        char[] password = SecretValue.GOODGAME_PASSWORD;

        AjaxLoginContainer alc = ggi.ajax().login(login, password);

        assertThat(alc.getCode(), is(4));
        System.out.println(alc);
    }
}
