package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 03.04.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxSettings {

    private AjaxChat chat;

    public final AjaxChat getChat() {
        return this.chat;
    }

    public final void setChat(final AjaxChat chat) {
        this.chat = chat;
    }

    @Override
    public final String toString() {
        return "settings{" +
                "chat=" + this.chat +
                '}';
    }
}
