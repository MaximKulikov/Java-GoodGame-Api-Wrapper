package ru.maximkulikov.goodgame.api.chatmodels;

import ru.maximkulikov.goodgame.api.ChatResponses;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 12.01.2017.
 */
public class Response {

    private ChatResponses type;

    private ResChatObject answer;

    public Response(ChatResponses type, ResChatObject answer) {
        this.type = type;
        this.answer = answer;
    }

    public final ResChatObject getAnswer() {
        return answer;
    }

    public final ChatResponses getType() {
        return type;
    }
}
