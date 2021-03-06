# Java GoodGame.Ru API Wrapper 

![Gource visualization](https://github.com/MaximKulikov/Java-GoodGame-Api-Wrapper/blob/master/gource.png?raw=true)  

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e363ff624c2343e8acbb08e96b61d7d6)](https://www.codacy.com/app/MaximKulikov/Java-GoodGame-Api-Wrapper?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Trinion/Java-GoodGame-Api-Wrapper&amp;utm_campaign=Badge_Grade)
 [![CircleCI](https://circleci.com/gh/MaximKulikov/Java-GoodGame-Api-Wrapper/tree/master.svg?style=svg)](https://circleci.com/gh/MaximKulikov/Java-GoodGame-Api-Wrapper/tree/master)

# Меню
    
**[Описание](#Описание)**  
.  *[Простой пример](#Простой-пример)*    
.  *[Простой пример с параметром](#Простой-пример-с-параметром)*  
**[Соответствия JGAW и Goodgame API](#Соответствия-jgaw-и-goodgame-api)**  
**[Авторизация ](#Авторизация)**  
.  *[Пример получения авторизационного токена](#Пример-получения-авторизационного-токена)*  
.  *[Пример получения Access Token](#Пример-получения-access-token)*  
**[Еще одна авторизация](#Еще-одна-авторизация)**
**[И еще одна авторизация](#И-еще-одна-авторизация)**
**[API чата](#api-чата)**  
.  *[Соответствие запросам на сервер чата классам библиотеки](#Соответствие-запросам-на-сервер-чата-классам-библиотеки)*    
.  *[Соответствие ответов сервера чата классам библиотеки](#Соответствие-ответов-сервера-чата-классам-библиотеки)*      
**[Документация](#Документация)**  
**[Зависимости](#Зависимости)**  
**[Установка](#Установка)**  
**[In Progress](#in-progress)**  


# Описание

**JGAW** - обертка над [GoodGame API](https://github.com/GoodGame/API), позволяющая выполнять асинхронные запросы. 

За основу взята разработка `Matthew J. Bell @urgrue` [Java-Twitch-Api-Wrapper](https://github.com/urgrue/Java-Twitch-Api-Wrapper)

**JGAW** позволяет отправлять запросы и получать ответы от`GoodGame.Ru` в виде объектов `Java`.
Библиотека разделена на несколько частей:  
1. АПИ Стримингового сервиса  
  1.1. Реализованы методы из [GoodGame (v2)](http://api2.goodgame.ru/apigility/documentation/Goodgame-v2)  
  1.2. Реализованы методы из Github [GoodGame API](https://github.com/GoodGame/API)  
2. АПИ чата  
  2.1.  Реализованы методы из Github [GoodGame Chat API](https://github.com/GoodGame/API/blob/master/Chat/protocol.md)

Для запроса GoodGame (v2) `GET /channel/:channel/subscribers` используется экземпляр класса GoodGame(), 
в котором вызывается метод `gg.channels().getSubscribers(channelName, new SubscriberResponseHandler()`  

Вызовы апи Github объединены в `gg.githubapi().methods()` и почти все возвращают необработанный json объект
 
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
            public void onSuccess(SubscribersContainer subscribers) {
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
| Refresh Token                   |  получаем вместе с  Access Token        | 

| API                                 |  JGAW               |  Описание               |
|-------------------------------------|---------------------------------------------------------------------------|-------------------------|
| `GET /player/:src`                  | `gg.player().getPlayer(channelId, new PlayerResponseHandler())`                                                 | Получение информации о плеере.  |
| `GET /streams`                      | `gg.streams().getStreams(new StreamsResponseHandler()` <br /> `gg.streams().getStreams(params, new StreamsResponseHandler()`    | Получение информации обо всех онлайн стримах на Goodgame. Можно использовать query-параметры.  |
| `GET /streams[/:channel]`           | `gg.streams().getChannel(channelName, new StreamChannelResponseHandler()`                                                 | Получение информации о конкретном стриме. Query-параметры не работают.  |
| `GET /channel/:channel/subscribers` | `gg.channels().getSubscribers(channelName, new SubscriberResponseHandler())`<br /> `gg.channels().getSubscribers(channel, requestParams, new SubscriberResponseHandler()`   | Список подписчиков указанного канала.  |
| `GET /channel/:channel/premiums`    | `gg.channels().getPremiums(channel, new PremiumsResponseHandler())` <br /> `gg.channels().getPremiums(channel, requestParams, new PremiumsResponseHandler()`   | Список премиум подписчиков указанного канала.  |
| `GET /channel/:channel/donations`   | `gg.channels().getDonations(channel, new DonationsResponseHandler())` <br /> `gg.channels().getDonations(channel, requestParams, new DonationsResponseHandler()`  | Список поддержки указанного канала.  |
| `GET /chat/token`                   | `gg.chat().getChatToken(new ChatTokenResponseHandler())`   | Получение токена чата для конкретного пользователя. Id-пользователя определяется из Access Token'a.  |
| `GET /games`                        | `gg.games().getGames(new GamesResponseHandler())` <br /> `gg.games().getGames(requestParams, new GamesResponseHandler()`   | Получение коллекции игр.  |
| `GET /games[/:game]`                | `gg.games().getGame(gameUrl, new GameResponseHandler())`   | Получение информации по игре, зная ее url.  |
| `GET /info`                         | `gg.info().getInfo(new InfoResponseHandler())`   | Получение информации по Access Token'у.  |
| `GET /smiles/`         | `gg.smiles().getSmiles(new SmilesResponseHandler()` <br /> `gg.smiles().getSmiles(page, new SmilesResponseHandler()`   | Получение коллекции смайлов.  |
| `GET /smiles[/:channel_id]`         | `gg.smiles().getChannelSmiles(new SmilesResponseHandler()` <br /> `gg.smiles().getChannelSmiles(channelId, page, new SmilesResponseHandler()`   | Получение коллекции смайлов канала.  |
| `http://goodgame.ru/api/getchannelstatus`    | `gg.githubapi().getChannelStatus(channelId, new GitHubSharedHandler()`  | Получение информации о статусе плееров GoodGame.  |
| `http://goodgame.ru/api/getggchannelstatus`    | `gg.githubapi().getGgChannelStatus(channelId, new GitHubSharedHandler()`  | Получение информации о статусе плееров GoodGame.  |
| `http://goodgame.ru/api/getupcomingbroadcast`  | `gg.githubapi().getUpcomingBroadcast(channelId, new GitHubSharedHandler()`   | Получение информации о предстоящей трансляции (анонс).  |
| `http://goodgame.ru/api/getchannelsbygame`     | `gg.githubapi().getChannelsByGame(gameUrl, new GitHubSharedHandler)`   | Получение информации о трансляциях по конкретной игре.  |
| `http://goodgame.ru/api/token`                 | `gg.githubapi().getToken("username", "password", gg.auth(), new GitHubTokenHandler()`   | Получение токена авторизации. Установите значения токенов   |
| `http://goodgame.ru/api/getchannelsubscribers` | `gg.githubapi().getChannelSubscribers(gg.auth(), new GitHubChannelSubscribersResponseHandler()`   | Список подписчиков.  |

**`http://goodgame.ru/api/getupcomingbroadcast`**: возвращает 404 страницу в HTML разметке, любой запрос вылетет в блок `onFailure(Throwable throwable)` (актуально на 20 янв 2017)  
**`http://goodgame.ru/api/getchannelsbygame`** вернет пустой массив (актуально 20 янв 2017)
**`http://goodgame.ru/api/getchannelsubscribers`** Не понимаю какой токен он хочет, возвращает success=false.


## Авторизация


Для получения доступа к командам, требующих специальные права требуется получить токен доступа ***accessToken***. 
accesToken можно получить, зная авторизационный код ***authentificationCode*** или ***refreshToken***.

Ваше приложение должно быть зарегистрировано GoodGame как OAuth 2.0 приложение. 
Зарегистрировать приложение можно по ссылке `https://goodgame.ru/user/*ВашID*/edit`.   
`Redirect URI` необходимо указать `http://127.0.0.1:23523/gg-authorize.html`. Можно выбрать порт, отличный от `23523`. 
 Вы так же можете сделать собственные ресурсные страницы, аналогичные `gg-authorize.html` и пр. с отличными от стандартных названиями. 
 

#### Пример получения авторизационного токена 

```java
class Example {
    example() {
        GoodGame gg = new GoodGame();

        // Устанавливаем название приложения.
        gg.setClientId("TestGoodGameApi"); 

        // Устанавливаем Redirect URI.
        URI callbackUri = new URI("http://127.0.0.1:23523/gg-authorize.html");

        // Получаем ссылку для авторизации. Установите все необходимые права приложению. 
        // Передайте сгенерированную строку третим параметром или вызовите getState().
        String authUrl = gg.auth().getAuthenticationUrl(callbackUri, Scopes.CHANNEL_SUBSCRIBERS, Scopes.CHAT_TOKEN);

        // Отправьте пользователю сформированную ссылку по которой он сможет пройти и авторизовать приложение для работы от его имени
        openWebpage(authUrl);

        // Ожидайте пока пользователь одобрит или запретит использовать приложение 
        // ВНИМАНИЕ: на этом методе приложение повиснет пока не получит ответ от пользователя
        boolean authSuccess = gg.auth().awaitAutorizationCode();

        // Проверяем, что авторизация успешна
        if (authSuccess) {

            // Авторизационный код сохранился в объекте Authenticator, его можно получить
            String authentificationCode = gg.auth().getAutorizationCode();           
            System.out.println("Авторизационный код: " + authentificationCode);
        } else {

        // Авторизация не удалась, возможно пользователь отклонил запрос
        System.out.println(gg.auth().getAuthenticationError());
        }
    }
}
```

***Как это работает:*** Будет запущен локальный веб сервер на который ссылается `Redirect URI`,  
на которую после одобрения или запрета использовать приложение будет переброшен пользователь. 
Как только ответ будет получен, система извлечет нужные параметры или выведет ошибку и закроет сокет.


#### Использование собственных страниц

Авторизационные страницы оторажаются пользователю, когда GoodGame переадрессует его. Из ответа будут извлечены Access Tonen, показана ошибка или успешное выполнение. 

Существует 3 страницы, которые возможно переписать: 
* Auth: На эту страницу произойдет переадресация GoodGame. Она содержит javascript, который извлекает Access Token из URL.
* Failure: Отображает ошибку, что бы пользователь понял что пошло не так.
* Success: Отображает успешную авторизацию.

Для изпользование собственных страниц просто передайте URL объекты (обычно получаются из [Class.getResource()](https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html#getResource(java.lang.String)) и передайте в метод `awaitAccessToken()`.

```
    authView = getClass().getResource("/my_auth.html");
    failureView = getClass().getResource("/my_auth_failure.html");
    successView = getClass().getResource("/my_auth_success.html");

    // Ожидайте пока пользователь одобрит или запретит использовать приложение 
    // ВНИМАНИЕ: на этом методе приложение повиснет пока не получит ответ от пользователя
    boolean authSuccess = gg.auth().awaitAccessToken(authView, failureView, successView);
```
*authView*

Эта страница откроется только на несколько мгновений, после чего произойдет переадрессацияo.
На этой странице необходимо включить `gg-auth.js` в нутри тега `<head>`:
```HTML
<script type="text/javascript" src="gg-auth.js"></script>
```

*successView*

Эта страница отобразится при одобрении использовать приложение. Можно сообщить пользователю, что он может вернуться к приложению.

*failureView*

Эта страница показывает сообщение с ошибкой, если пользователь отклонил запрос на использование приложения.  
Сообщение о ошибке и его описание  передается в переменных через URL.

* `error`: Заголовок ошибки.
* `error_description`: Подробное описание ошибки.

### Пример получения Access Token


```java
class Example {
    example() {

        // Client Secret, который был указан на странице регситрации OAuth 2.0 приложения
        String clientSecret = "ApplicationSecret";

        // true - используем AutorizationCode для получения Access Token, false - используем RefreshToken
        boolean useAutorizationCode = true;

        gg.oauth().getAccessToken(gg.auth(), clientSecret, useAutorizationCode, new OauthResponseHandler() {

            @Override
            public void onSuccess(AccessToken accessToken) {       
                // Успешно волучили Access Token, можем получить доп параметры из полученного объекта
                // Access Token и Refresh Token сохранились в объекте Authenticator, их можно получить
                // gg.auth().getAccessToken();
                // gg.auth().getRefreshToken();
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

Если у вас уже имеется Access Token или Refresh Token, их можно установить вручную  
```
gg.auth().setAccessToken("my-access-token");
gg.auth().setRefreshToken("my-refresh-token");
```

# Еще одна авторизация

Получить токен для работы с чатом можно методом `gg.ajax().login(String login, String password, new AjaxLoginResponseHandler handler {});`  
  
# И еще одна авторизация

В блоке githubapi так же есть авторизация, путем передачи логина и пароля. 

# API чата
Для работы требуется создать экземпляр класса и унаследовать его от GoodChat, для подключения вызовите .connect. 
Соединение принудительно прервется через 24 часа или при вызове метода stop().

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

Пример авторизации в чате:
```java
class ChatSendMessageExample extends GoodChat {
    private void example() {
     
        sendMessage(new ReqAutorizationContainer(1, myUserId, myChatToken)); 
    } 
}
```


| Запросы                | Классы ReqChatObject                                                                                                                                       |
|------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| auth                   | `ReqAutorizationContainer(int siteId, int userId, String token)`                                                                                           |
| get_channels_list      | `ReqChannelsListContainer()` <br /> `ReqChannelsListContainer(int start, int count)`                                                                       |
| join                   | `ReqJoinContainer(String channelId)` <br />`ReqJoinContainer(String channelId, boolean hidden, boolean mobile)`                                            |
| unjoin                 | `ReqUnjoinContainer(String channelId)`                                                                                                                     |
| get_users_list2        | `ReqUsersListContainer(String channelId)`                                                                                                                  |
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
| refresh_groups v.2     | `ReqRefreshGroupsContainer(String channelId)`                                                                                                              |

**send_private_message**: Приватное сообщение, отправленное таким способом можно отловить только с использованием API (в чатике на сайте оно не появится)
**get_user_info** Не возвращает ответа, похоже было изменено на get_user_info2,  

### Соответствие ответов сервера чата классам библиотеки

Ответы от сервера приходят в переопределенный метод onMessage
```java
class ChatAnswerExample extends GoodChat {

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
| isPremium          | ResPremium         |
| accepted         |                    |
| moder_rights     | ResModeratorRight  |
| Остальное:UNKNOWN| null               |
| "reconnecting", "reconnected", "stream_moders_list", "random_result", "update_user_info" | Не реализовано |




## Документация
* Документация Github [GoodGame API](https://github.com/GoodGame/API)
* Еще документация [GoodGame API](http://api2.goodgame.ru/apigility/documentation/Goodgame-v2)
* [Топик на форуме](https://goodgame.ru/topic/67865/)
* [JavaDoc](https://trinion.github.io/Java-GoodGame-Api-Wrapper/)

## Зависимости

* [Java Async HTTP Client](https://github.com/urgrue/java-async-http/releases/tag/2.1.2) ver. 2.1.2
* [Jackson JSON Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.4.5) ver. 2.4.5 
* [Eclipse Websocket Client](https://mvnrepository.com/artifact/org.eclipse.jetty.websocket/websocket-client) ver. 9.2.19.v20160908
* [Apache Commons Lang](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.4) ver 3.4

## Установка

[Java-GoodGame-Api-Wrapper 1.0.2](https://github.com/MaximKulikov/Java-GoodGame-Api-Wrapper/releases/tag/1.0.2)


pom.xml
```xml
<project>
    <dependencies>
    
        <dependency>
            <groupId>ru.maximkulikov</groupId>
            <artifactId>goodgame-api-wrapper</artifactId>
            <version>1.0.2</version>
            <systemPath>${project.basedir}/lib/goodgame-api-wrapper.jar</systemPath>
        </dependency>
           
    </dependencies>
   
</project>
```

## Типовая реализация

В библиотеке есть класс `GoodGameImplementation` в котором есть типовая реализация библиотеки.
       



 
 