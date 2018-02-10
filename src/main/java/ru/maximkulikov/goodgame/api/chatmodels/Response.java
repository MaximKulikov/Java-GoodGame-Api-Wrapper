package ru.maximkulikov.goodgame.api.chatmodels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.maximkulikov.goodgame.api.ChatResponses;

/**
 * @author Maxim Kulikov
 * @since 12.01.2017
 */
@AllArgsConstructor
public class Response {

    private @Getter ChatResponses type;

    private @Getter ResChatObject answer;

}
