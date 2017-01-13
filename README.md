# Async GoodGame API Wrapper
JGAW - обертка над [GoodGame API](https://github.com/GoodGame/API), позволяющая выполнять асинхронные запросы. 

Please feel free to report any issues or contribute code.

За основу проекта взята разработка `Matthew J. Bell @urgrue` [Java-Twitch-Api-Wrapper](https://github.com/urgrue/Java-Twitch-Api-Wrapper)

##In Progress

Разобраться с путаницей в авторизационном токене и токене доступа  
Добавить недостающие модели ответов чата
Добавить недостающие модели запросов чата
Сделать тесты  
Написать вменяемую инструкцию  
Выложить релиз  


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
GoodGame gg = new GoodGame();
gg.setClientId("shjdkashjkfdl"); // Идентификатор приложения   (https://goodgame.ru/user/***userId***/edit) 

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
```

#### Простой пример с параметром


```java
/* Получение подписчиков, начиная с конкретного времени */
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
```
### Вызовы апи стримингового сервиса

***gg.auth().awaitAutorizationCode()***  
// Получение авторизационного токена

***gg.oauth().getAccessToken()***   
//Получение токена доступа  

***gg.player().getPlayer()***   
// Получение информации о плеере, передается Player source  

***gg.streams.getChannel()***   
// Получение информации о конкретном стриме. Query-параметры не работают.  

***gg.channels().getSubscribers(channel, new SubscriberResponseHandler()***   
// Список подписчиков указанного канала. Scope: channel.subscribers  

***gg.channels().getSubscribers(channel, requestParams, new SubscriberResponseHandler()***   
// Список подписчиков указанного канала c параметрами. Scope: channel.subscribers  

***gg.channels().getPremiums(channel, new PremiumsResponseHandler()***   
// Список премиум подписчиков указанного канала. Scope: channel.premiums  

***gg.channels().getPremiums(channel, requestParams, new PremiumsResponseHandler()***   
// Список премиум подписчиков указанного канала с параметрами. Scope: channel.premiums  

***gg.channels().getDonations(channel, new DonationsResponseHandler()***   
// Список поддержки указанного канала. Scope: channel.donations  

***gg.channels().getDonations(channel, requestParams, new DonationsResponseHandler()***   
// Список поддержки указанного канала с параметрами. Scope: channel.donations  

***gg.chat().getChatToken(new ChatTokenResponseHandler()***    
// Получение токена чата для конкретного пользователя. Id-пользователя определяется из Access Token'a. Scope: chat.token  

***gg.games().getGames(new GamesResponseHandler()***   
// Получение коллекции игр  

Не проверено ***gg.games().getGames(requestParams, new GamesResponseHandler()***   
// Получение коллекции игр  

***gg.games().getGame(gameUrl, new GameResponseHandler()***  
// Получение информации по игре, зная ее url  

***gg.info().getInfo(new InfoResponseHandler()***   
// Получение информации по Access Token'у  

***gg.smiles().getSmiles(new SmilesResponseHandler()***   
// Получение коллекции смайлов. Если не указан channel_id, то вернется список всех смайлов.  

***gg.smiles().getChannelSmiles(channelId, new SmilesResponseHandler()***   
//Получение коллекции смайлов.  

***gg.githubapi()*** Возврщает данные в json формате. Спасибо ГГ за динамические ключи  
Как-то реализовано то что тут описано https://github.com/GoodGame/API/blob/master/Streams/stream_api.md  


# API чата
Для работы требуется создать экземпляр класса и унаследовать его GoodChat, для подключения вызовите .connect

```java
Main{ {
    GGChat goodgameChat = new GGChat();
    goodgameChat.connect();
} }

GGChat extends GoodChat {  
   @Override  
   public void onMessage(Response answer) {   
   answer.getType(); // Возвращает значение Enum с типом пришедшего сообщения
   answer.getAnswer(); // Возвращает базовый ResChatObject  
   }  
}  
```

***Пример***
```java
   @Override  
   public void onMessage(Response answer) {   
       switch (answer.getType()) {  
            case CHANNEL_HISTORY:  
                ResChannelHistory resChannelHistory = (ResChannelHistory) answer.getAnswer();  
                System.out.println(answer.getAnswer());  
        }
   } 
```

### Соответствие запросам на сервер чата классам библиотеки

Запросы на сервер отправляются методом sendMessage(ReqChatObject chatObject) в унаследованном от GoodChat классе, 
после соединения с сервером


| Запросы                | Классы ReqChatObject                                                                                                                                     |
|------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| auth                   | ***ReqAutorizationContainer***(int siteId, int userId, String token)                                                                                           |
| get_channels_list      | ***ReqChannelsListContainer***() <br /> ***ReqChannelsListContainer***(int start, int count)                                                                         |
| join                   | ***ReqJoinContainer***(String channelId) <br />***ReqJoinContainer***(String channelId, boolean hidden, boolean mobile)                                              |
| unjoin                 | ***ReqUnjoinContainer***(String channelId)                                                                                                                     |
| get_users_list         | ***ReqUsersListContainer***(String channelId)                                                                                                                  |
| get_channel_counters   | ***ReqChannelCountersContainer***(String channelId)                                                                                                            |
| get_ignore_list        | ***ReqIgnoreListContainer***()                                                                                                                                 |
| add_to_ignore_list     | ***ReqAddToIgnoreListContainer***(String userId)                                                                                                               |
| del_from_ignore_list   | ***ReqDelFromIgnoreListContainer***(String userId)                                                                                                             |
| get_channel_history    | ***ReqChannelHistoryContainer***(String channelId)                                                                                                             |
| send_message           | ***ReqSendMessageContainer***(String channelId, String text) <br /> ***ReqSendMessageContainer***(String channelId, String text, Boolean hideIcon, Boolean mobile)   |
| send_private_message   | ***ReqPrivateMessageContainer***(String channelId, String userId, String text)                                                                                 |
| remove_message         | ***ReqRemoveMessageContainer***(String channelId, String messageId)                                                                                            |
| ban                    | ***ReqBanContainer***(String channelId, String banChannel, String userId, Long duration, String reason, String comment, Boolean show_ban)                      |
| warn                   | ***ReqWarnContainer***(String channelId, String userId, String reason)                                                                                         |
| new_poll               | ***ReqNewPollContainer***(String channelId, String moderId, String moderName, String title, List<String> answers)                                              |
| get_poll               | ***ReqGetPollContainer***(String channelId)                                                                                                                    |
| vote                   | ***ReqVoteContainer***(String channelId, int answerId)                                                                                                         |
| get_poll_results       | ***ReqPollResultsContainer***(String channelId)                                                                                                                |
| get_user_info          | ***ReqGetUserInfoContainer***(String userId)                                                                                                                   |
| make_moderator         | ***ReqMakeModeratorContainer***(String channelId, String userId)                                                                                               |
| clean_moderator        | ***ReqCleanModeratorContainer***(String channelId, String userId)                                                                                              |
| refresh_premium        | //TODO   |
| refresh_groups v.2     | //TODO   |


### Соответствие ответов сервера чата классам библиотеки

Ответы от сервера приходят в переопределенный метод onMessage
```java
    @Override
    public void onMessage(Response answer) {
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
| setting v.2      |  //TODO            |
| ignore_list      | ResIgnoreList      |
| channel_history  | ResChannelHistory  |
| motd             | ResMotd            |
| slowmod          | ResSlowmod         |
| message          | ResMessage         |
| private_message  | ResPrivateMessage  |
| remove_message   | ResRemoveMessage   |
| user_ban         | ResUserBan         |
| user_warn        | ResWarn            |
| new_poll         | //TODO             |
| poll_results     | ResPollResults     |
| user             | ChatUser           |
| update_rights    | ResUpdateRights    |
| update_groups v.2| //TODO             |
| update_premium   | ResUpdatePremium   |
| error            | ResError           |
| payment          | ResPayment         |
| premium          | ResPremium         |
| Остальное:UNKNOWN| null               |

ResRefreshPremium


#Text Below this not edited yet
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

## Документация
* Документация Github [GoogGame API](https://github.com/GoodGame/API)
* Еще документация [GoogGame API](http://api2.goodgame.ru/apigility/documentation/Goodgame-v2)
* [Топик на форуме](https://goodgame.ru/topic/67865/)  

## Зависимости

* [Java Async HTTP Client](https://github.com/urgrue/java-async-http/releases/tag/2.1.2) ver. 2.1.2
* [Jackson JSON Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.4.5) 
* [Eclipse Websocket Client](https://mvnrepository.com/artifact/org.eclipse.jetty.websocket/websocket-client) ver. 9.2.19.v20160908

## Install

* Скоро

## Roadmap

Выпустить релиз