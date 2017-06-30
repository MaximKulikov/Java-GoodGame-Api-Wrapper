package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 03.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxSettings {

    private AjaxChat chat;

    /**
     * @return chat
     */
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
