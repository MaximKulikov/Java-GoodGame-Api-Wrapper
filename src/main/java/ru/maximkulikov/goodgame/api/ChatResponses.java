package ru.maximkulikov.goodgame.api;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 12.01.2017.
 */
public enum ChatResponses {
    WELCOME,
    SUCCESS_AUTH,
    CHANNELS_LIST,
    SUCCESS_JOIN,
    SUCCESS_UNJOIN,
    JOIN_TO_ROOM,
    USERS_LIST,
    CHANNEL_COUNTERS,
    LIST,
    SETTING, // нет контейнера?
    IGNORE_LIST,
    CHANNEL_HISTORY,
    MESSAGE,
    PRIVATE_MESSAGE,
    REMOVE_MESSAGE,
    USER_BAN,
    USER_WARN,
    NEW_POLL, //нет контейнера?
    POLL_RESULTS,
    USER,
    UPDATE_RIGHTS,
    UPDATE_GROUPS, //нет контейнера?
    ERROR,
    UNKNOWN;


}