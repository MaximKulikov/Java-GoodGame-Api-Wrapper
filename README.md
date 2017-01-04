# Async GoodGame API Wrapper
JGAW is a complete asynchronous java wrapper for interaction with v2 of the [GoogGame API](https://github.com/GoodGame/API).

Please feel free to report any issues or contribute code.

#Done
gg.auth().awaitAutorizationCode() // Получение авторизационного токена
gg.oauth().getAccessToken() //Получение токена доступа
gg.player().getPlayer() // Получение информации о плеере, передается Player source
gg.streams.getChannel() // Получение информации о конкретном стриме. Query-параметры не работают.
gg.channels().getSubscribers(channel, new SubscriberResponseHandler() // Список подписчиков указанного канала. Scope: channel.subscribers
gg.channels().getSubscribers(channel, requestParams, new SubscriberResponseHandler() // Список подписчиков указанного канала c параметрами. Scope: channel.subscribers
gg.channels().getPremiums(channel, new PremiumsResponseHandler() // Список премиум подписчиков указанного канала. Scope: channel.premiums
gg.channels().getPremiums(channel, requestParams, new PremiumsResponseHandler() // Список премиум подписчиков указанного канала с параметрами. Scope: channel.premiums
gg.channels().getDonations(channel, new DonationsResponseHandler() // Список поддержки указанного канала. Scope: channel.donations
gg.channels().getDonations(channel, requestParams, new DonationsResponseHandler() // Список поддержки указанного канала с параметрами. Scope: channel.donations
gg.chat().getChatToken(new ChatTokenResponseHandler()  // Получение токена чата для конкретного пользователя. Id-пользователя определяется из Access Token'a. Scope: chat.token
gg.games().getGames(new GamesResponseHandler() // Получение коллекции игр
Не проверено gg.games().getGames(requestParams, new GamesResponseHandler() // Получение коллекции игр
gg.games().getGame(gameUrl, new GameResponseHandler() // Получение информации по игре, зная ее url
gg.info().getInfo(new InfoResponseHandler() // Получение информации по Access Token'у
gg.smiles().getSmiles(new SmilesResponseHandler() // Получение коллекции смайлов. Если не указан channel_id, то вернется список всех смайлов.
gg.smiles().getChannelSmiles(channelId, new SmilesResponseHandler() //Получение коллекции смайлов.



#In Progress


#Text Below this not edited yet

## Basics

Using the wrapper is as simple as instantiating the `GoodGame` object and then calling the appropriate endpoint functions.

For example, a `GET /streams/featured` request would map to the `twitch.streams().getFeatured()` function; and `GET /channels/lirik` would map to `twitch.channels().get("lirik")`.

Responses are handled via callbacks passed via a handler with each function call. This process is outlined in the following examples.

#### Basic Example

```java
Twitch twitch = new Twitch();
twitch.setClientId("shjdkashjkfdl"); // This is your registered application's client ID

twitch.channels().get("lirik", new ChannelResponseHandler() {
    @Override
    public void onSuccess(Channel channel) {
        /* Successful response from the Twitch API */
        System.out.println(channel);
    }

    @Override
    public void onFailure(int statusCode, String statusMessage, String errorMessage) {
        /* Twitch API responded with an error message */
    }

    @Override
    public void onFailure(Throwable e) {
        /* Unable to access Twitch, or error parsing the response */
    }
});
```

#### Basic Example with Parameters

Some endpoints accept optional parameters as specified in the [Twitch API](https://github.com/justintv/Twitch-API). These parameters can be passed with a `RequestParams` object and passed to the request method.

```java
/* Update my stream */
RequestParams params = new RequestParams();
params.put("status", "Let's kill some zombies!");
params.put("game", "DayZ");

client.channels().put("my-user-name", params, new ChannelResponseHandler() {
    @Override
    public void onSuccess(Channel channel) {
        /* Success, we got the updated Channel object */
    }

    @Override
    public void onFailure(int statusCode, String statusMessage, String errorMessage) {
        /* Twitch denied the request */
    }

    @Override
    public void onFailure(Throwable e) {
        /* Unable to access Twitch, or error parsing the response */
    }
});
```

## Authentication

### Implicit Grant Flow

The wrapper provides the functionality for authenticating users of your application following the [Implicit Grant Flow](https://github.com/justintv/Twitch-API/blob/master/authentication.md#implicit-grant-flow). 

To use authentication, your application must be registered with Twitch and the `Redirect URI` should be set like the following:
`http://127.0.0.1:23522`. You may choose a different port other than `23522` if you wish, but the rest of the URI must remain exactly as specified above.

The authentication process is explained in the following code example.

```java
Twitch twitch = new Twitch();
twitch.setClientId("shjdkashjkfdl"); // This is your registered application's client ID

/* Specify your registered callback URI */
URI callbackUri = new URI("http://127.0.0.1:23522/authorize.html");

/* Get the authentication URL. Note: you will set the required scopes needed here. */
String authUrl = twitch.auth().getAuthenticationUrl(twitch.getClientID(), callbackUri, Scopes.USER_READ, Scopes.CHANNEL_READ);

/* Send the user to the webpage somehow so that they can authorize your application */
openWebpage(authUrl);

/* Waits for the user to authorize or deny your application. Note: this function will block until a response is received! */
boolean authSuccess = twitch.auth().awaitAccessToken();

/* Check if authentication was successful */
if (authSuccess) {
  /* The access token is automatically set in the Twitch object and will be sent with all further API requests! */
  String accessToken = twitch.auth().getAccessToken(); // if we want to explicitly get it for some reason
  System.out.println("Access Token: " + accessToken);
} else {
  /* Authentication failed, most likely because the user denied the authorization request */
  System.out.println(twitch.auth().getAuthenticationError());
}
```

_How it works:_ A simple, secure, local-only socket server will be opened. Since the `Redirect URI` for your application is set to `127.0.0.1`, it will redirect the user to their localhost after authorizing the application. As soon as a response is received, either an access token or error, the socket will be closed.

##### Using Custom Authentication Views *(optional)*

Authentication views are HTML pages displayed to the user that will capture the application authorization callback and retrieve the access token, show an error message, or show the success message.

There are 3 views that can be overwritten: 
* Auth: This view is what the Twitch API will callback on. It contains javascript that will extract the access token from the URL fragment identifier.
* Failure: This view will display the error message to the user if authorization fails.
* Success: This view will display a successful authentication message to the user.

Using your own views is easy, simple pass URL objects (usually retrieved from [Class.getResource()](https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html#getResource(java.lang.String)) to the `awaitAccessToken()` function.

```java
authView = getClass().getResource("/my_auth.html");
failureView = getClass().getResource("/my_auth_failure.html");
successView = getClass().getResource("/my_auth_success.html");

/* Waits for the user to authorize or deny your application. Note: this function will block until a response is received! */
boolean authSuccess = twitch.auth().awaitAccessToken(authView, failureView, successView);
```

###### Creating the Views

*Auth*

This page will only be displayed to the user for a brief second before automatically redirecting the user. If you wish to overwrite it you must include `gg-auth.js` in the `<head>` tag:
```HTML
<script type="text/javascript" src="gg-auth.js"></script>
```

*Success*

This page's only purpose is to display a success message and perhaps inform the user they can go back to the application.

*Failure*

This page will display an error message to the user if authentication failed (such as they denied the request on Twitch). The error message and description is passed to this page view via the URL query string.

* `error`: error message.
* `error_description`: description of the error.

You can view the default pages in the [resources directory](https://github.com/urgrue/Java-Twitch-Api-Wrapper/tree/master/src/main/resources).

### Explicitly Setting Access Token

If you already have an access token, you can explicitly set it. This _**should not**_ be done prior to an application being distributed as the access token is directly linked to a single Twitch account.

```java
twitch.auth().setAccessToken("my-access-token-289489");
```

## Documentation
* [Javadocs](https://urgrue.github.io/Java-Twitch-Api-Wrapper/)
* The [Twitch API](https://github.com/justintv/Twitch-API) documentation will best explain the functionality of each endpoint. 

## Dependencies

* [Java Async HTTP Client](https://github.com/urgrue/java-async-http/releases/tag/2.1.2) ver. 2.1.2
* [Jackson JSON Processor - Databind](http://wiki.fasterxml.com/JacksonHome) // [Direct Download](http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.4.5/jackson-databind-2.4.5.jar) ver. 2.4.5

## Install

This library and the 2 above mentioned dependencies are required. A JAR with all dependencies already included is also provided.

* [Twitch API Wrapper Download](https://github.com/urgrue/Java-Twitch-Api-Wrapper/releases/tag/0.3)

## Roadmap

* Android and Gradle support.
