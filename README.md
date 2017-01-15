Code Style: [![Codacy Badge](https://api.codacy.com/project/badge/Grade/e363ff624c2343e8acbb08e96b61d7d6)](https://www.codacy.com/app/Trinion/Java-GoodGame-Api-Wrapper?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Trinion/Java-GoodGame-Api-Wrapper&amp;utm_campaign=Badge_Grade)  

# Async GoodGame API Wrapper
JGAW - обертка над [GoodGame API](https://github.com/GoodGame/API), позволяющая выполнять асинхронные запросы. 

Please feel free to report any issues or contribute code.

За основу проекта взята разработка `Matthew J. Bell @urgrue` [Java-Twitch-Api-Wrapper](https://github.com/urgrue/Java-Twitch-Api-Wrapper)

# Основная идея

Использование обертки позволяет отправлять запросы и получать ответы от`GoodGame` в виде объектов `Java`.
Библиотека разделена на несколько частей:  
1. АПИ Стримингового сервиса  
а. на сайте [GoodGame (v2)](http://api2.goodgame.ru/apigility/documentation/Goodgame-v2)  
б. на Github [GoodGame API](https://github.com/GoodGame/API)  
2. АПИ чата  

Для запроса GoodGame (v2) `GET /channel/:channel/subscribers` используется экземпляр класса GoodGame() 
в котором вызывается `gg.channels().getSubscribers(channelName, new SubscriberResponseHandler()`  

Вызовы апи Github объединены в `gg.githubapi().methods()` и почти все возвращают строку json
 
Работа с АПИ чата происходит в унаследованном от `GoodChat` классе


#### Простой пример

```java
class SimpleExample {
    public void example() {
        
        GoodGame gg = new GoodGame();
        
        // Идентификатор приложения   (https://goodgame.ru/user/***userId***/edit)
        gg.setClientId("shjdkashjkfdl");
        
        gg.smiles().getSmiles(new SmilesResponseHandler() {

            @Override
            public void onSuccess(SmilesContainer smiles) {
                 // Успешное получение объекта
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                // GoodGame сообщил об ошибке в запросе          
            }

            @Override
            public void onFailure(Throwable throwable) {
                // Ошибка взаимодействи я с сервером или обработки ответа
            }
        });
    }
}
```

#### Простой пример с параметром


```java
/* Получение подписчиков, начиная с конкретного времени */
class SimpleExample {
    public void example() {
        
        RequestParams params = new RequestParams();
        
        params.put("from_timestamp", "1453592975");

        gg.channels().getSubscribers("channelName", params, new SubscriberResponseHandler() {

            @Override
            public void onSuccess(SubscrurersContainer subscribers) {
                //Успешно
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                // GoodGame сообщил об ошибке в запросе 
            }

            @Override
            public void onFailure(Throwable e) {
            // Ошибка взаимодействи я с сервером или обработки ответа
            }
        });
    }
}
```
### Соответствия JGAW и Goodgame API 

| Получение Access Token'а        |  JGAW                                   |
|---------------------------------|-----------------------------------------|
| Запрос кода авторизации         |  `gg.auth().awaitAutorizationCode()`    |
| Запрос Access Token             |  `gg.oauth().getAccessToken()`          |
| Refresh Token                   |  Отсутствует                            | 

| API                                 |  JGAW               |  Описание               |
|-------------------------------------|---------------------------------------------------------------------------|-------------------------|
| `GET /player/:src`                  | `gg.player().getPlayer()`                                                 | Получение информации о плеере.  |
| `GET /streams`                      | //TODO    | Получение информации обо всех онлайн стримах на Goodgame. Можно использовать query-параметры.  |
| `GET /streams[/:channel]`           | //TODO `gg.streams.getChannel()`                                                 | Получение информации о конкретном стриме. Query-параметры не работают.  |
| `GET /channel/:channel/subscribers` | `gg.channels().getSubscribers(channel, new SubscriberResponseHandler())`<br /> `gg.channels().getSubscribers(channel, requestParams, new SubscriberResponseHandler()`   | Список подписчиков указанного канала.  |
| `GET /channel/:channel/premiums`    | `gg.channels().getPremiums(channel, new PremiumsResponseHandler())` <br /> `gg.channels().getPremiums(channel, requestParams, new PremiumsResponseHandler()`   | Список премиум подписчиков указанного канала.  |
| `GET /channel/:channel/donations`   | `gg.channels().getDonations(channel, new DonationsResponseHandler())` <br /> `gg.channels().getDonations(channel, requestParams, new DonationsResponseHandler()`  | Список поддержки указанного канала.  |
| `GET /chat/token`                   | `gg.chat().getChatToken(new ChatTokenResponseHandler())`   | Получение токена чата для конкретного пользователя. Id-пользователя определяется из Access Token'a.  |
| `GET /games`                        | `gg.games().getGames(new GamesResponseHandler())` <br /> `gg.games().getGames(requestParams, new GamesResponseHandler()`   | Получение коллекции игр.  |
| `GET /games[/:game]`                | `gg.games().getGame(gameUrl, new GameResponseHandler())`   | Получение информации по игре, зная ее url.  |
| `GET /info`                         | `gg.info().getInfo(new InfoResponseHandler())`   | Получение информации по Access Token'у.  |
| `GET /smiles[/:channel_id]`         | `gg.smiles().getSmiles(new SmilesResponseHandler()` <br /> `gg.smiles().getChannelSmiles(channelId, new SmilesResponseHandler()`   | Получение коллекции смайлов.  |
| `http://goodgame.ru/api/getggchannelstatus`    | `gg.githubapi().getChannelStatus()` <br /> `gg.githubapi().getGgChannelStatus`  | Получение информации о статусе плееров GoodGame.  |
| `http://goodgame.ru/api/getupcomingbroadcast`  | `gg.githubapi().getUpcomingBroadcast()`   | Получение информации о предстоящей трансляции (анонс).  |
| `http://goodgame.ru/api/getchannelsbygame`     | `gg.githubapi().getChannelsByGame()`   | Получение информации о трансляциях по конкретной игре.  |
| `http://goodgame.ru/api/token`                 | `gg.githubapi().getToken()`   | Получение токена авторизации.  |
| `http://goodgame.ru/api/getchannelsubscribers` | `gg.githubapi().getChannelSubscribers()`   | Список подписчиков.  |


# API чата
Для работы требуется создать экземпляр класса и унаследовать его от GoodChat, для подключения вызовите .connect

```java
class SimpleExample {
    public void example() {
        
        GGChat goodgameChat = new GGChat();
        
        goodgameChat.connect();
    } 

    class GGChat extends GoodChat {  
    
        @Override  
        public void onMessage(Response answer) {
            
            // Возвращает значение Enum с типом пришедшего сообщения
            answer.getType(); 
            
            // Возвращает базовый ResChatObject
            answer.getAnswer(); 
            
            // Пример:
            switch (answer.getType()) {  
                case CHANNEL_HISTORY:  
                    ResChannelHistory resChannelHistory = (ResChannelHistory) answer.getAnswer();  
                    System.out.println(answer.getAnswer());  
            }  
        }  
    }
}
```

### Соответствие запросам на сервер чата классам библиотеки

Запросы на сервер отправляются методом sendMessage(ReqChatObject chatObject) в унаследованном от GoodChat классе, 
после соединения с сервером


| Запросы                | Классы ReqChatObject                                                                                                                                       |
|------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| auth                   | `ReqAutorizationContainer(int siteId, int userId, String token)`                                                                                           |
| get_channels_list      | `ReqChannelsListContainer()` <br /> `ReqChannelsListContainer(int start, int count)`                                                                       |
| join                   | `ReqJoinContainer(String channelId)` <br />`ReqJoinContainer(String channelId, boolean hidden, boolean mobile)`                                            |
| unjoin                 | `ReqUnjoinContainer(String channelId)`                                                                                                                     |
| get_users_list         | `ReqUsersListContainer(String channelId)`                                                                                                                  |
| get_channel_counters   | `ReqChannelCountersContainer(String channelId)`                                                                                                            |
| get_ignore_list        | `ReqIgnoreListContainer()`                                                                                                                                 |
| add_to_ignore_list     | `ReqAddToIgnoreListContainer(String userId)`                                                                                                               |
| del_from_ignore_list   | `ReqDelFromIgnoreListContainer(String userId)`                                                                                                             |
| get_channel_history    | `ReqChannelHistoryContainer(String channelId)`                                                                                                             |
| send_message           | `ReqSendMessageContainer(String channelId, String text)` <br /> `ReqSendMessageContainer(String channelId, String text, Boolean hideIcon, Boolean mobile)` |
| send_private_message   | `ReqPrivateMessageContainer(String channelId, String userId, String text)`                                                                                 |
| remove_message         | `ReqRemoveMessageContainer(String channelId, String messageId)`                                                                                            |
| ban                    | `ReqBanContainer(String channelId, String banChannel, String userId, Long duration, String reason, String comment, Boolean show_ban)`                      |
| warn                   | `ReqWarnContainer(String channelId, String userId, String reason)`                                                                                         |
| new_poll               | `ReqNewPollContainer(String channelId, String moderId, String moderName, String title, List<String> answers)`                                              |
| get_poll               | `ReqGetPollContainer(String channelId)`                                                                                                                    |
| vote                   | `ReqVoteContainer(String channelId, int answerId)`                                                                                                         |
| get_poll_results       | `ReqPollResultsContainer(String channelId)`                                                                                                                |
| get_user_info          | `ReqGetUserInfoContainer(String userId)`                                                                                                                   |
| make_moderator         | `ReqMakeModeratorContainer(String channelId, String userId)`                                                                                               |
| clean_moderator        | `ReqCleanModeratorContainer(String channelId, String userId)`                                                                                              |
| refresh_premium        | `ReqRefreshPremiumContainer(String channelId)`                                                                                                             |
| refresh_groups v.2     | `ReqRefreshGroupsContainer(final String channelId)`                                                                                                         |


### Соответствие ответов сервера чата классам библиотеки

Ответы от сервера приходят в переопределенный метод onMessage
```java
class SimpleExample extends GoodChat {
    
    @Override
    public void onMessage(Response answer) {
    }
    
}
```

| Ответы API       |     Классы         |  
|------------------|--------------------|
| welcome          | ResWelcome         |
| success_auth     | ResAutorization    |
| channels_list    | ResChannelsList    |
| success_join     | ResJoin            |
| success_unjoin   | ResUnjoin          |
| join_to_room     | ResJoinToRoom      |
| users_list       | ResUsersList       |
| channel_counters | ResChannelCounters |
| list             | ResModeratorsList  |
| setting v.2      | ResSettings        |
| ignore_list      | ResIgnoreList      |
| channel_history  | ResChannelHistory  |
| motd             | ResMotd            |
| slowmod          | ResSlowmod         |
| message          | ResMessage         |
| private_message  | ResPrivateMessage  |
| remove_message   | ResRemoveMessage   |
| user_ban         | ResUserBan         |
| user_warn        | ResWarn            |
| new_poll         | ResNewPoll         |
| poll_results     | ResPollResults     |
| user             | ChatUser           |
| update_rights    | ResUpdateRights    |
| update_groups v.2| ResUpdateGroups    |
| update_premium   | ResUpdatePremium   |
| error            | ResError           |
| payment          | ResPayment         |
| premium          | ResPremium         |
| Остальное:UNKNOWN| null               |



#Text Below this not edited yet
## Authentication

### Implicit Grant Flow

The wrapper provides the functionality for authenticating users of your application following the [Implicit Grant Flow](https://github.com/justintv/Twitch-API/blob/master/authentication.md#implicit-grant-flow). 

To use authentication, your application must be registered with Twitch and the `Redirect URI` should be set like the following:
`http://127.0.0.1:23522`. You may choose a different port other than `23522` if you wish, but the rest of the URI must remain exactly as specified above.

The authentication process is explained in the following code example.

```
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

```
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

```
twitch.auth().setAccessToken("my-access-token-289489");
```

## Документация
* Документация Github [GoogGame API](https://github.com/GoodGame/API)
* Еще документация [GoogGame API](http://api2.goodgame.ru/apigility/documentation/Goodgame-v2)
* [Топик на форуме](https://goodgame.ru/topic/67865/)
* [JavaDoc](https://trinion.github.io/Java-GoodGame-Api-Wrapper/)

## Зависимости

* [Java Async HTTP Client](https://github.com/urgrue/java-async-http/releases/tag/2.1.2) ver. 2.1.2
* [Jackson JSON Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.4.5) ver. 2.4.5 
* [Eclipse Websocket Client](https://mvnrepository.com/artifact/org.eclipse.jetty.websocket/websocket-client) ver. 9.2.19.v20160908

## Install

* Скоро

## In Progress

Разобраться с путаницей в авторизационном токене и токене доступа      
Написать вменяемую инструкцию    
Проверить работу  
Сделать тесты  
Выложить альфа .jar релиз  