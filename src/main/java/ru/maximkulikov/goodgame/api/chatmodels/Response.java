package ru.maximkulikov.goodgame.api.chatmodels;

import ru.maximkulikov.goodgame.api.ChatResponses;

/**
 * @author Maxim Kulikov
 * @since 12.01.2017
 */
public class Response {

    private ChatResponses type;

    private ResChatObject answer;

    public Response(final ChatResponses type, final ResChatObject answer) {
        this.type = type;
        this.answer = answer;
    }

    public final ResChatObject getAnswer() {
        return this.answer;
    }

    public final ChatResponses getType() {
        return this.type;
    }
}
