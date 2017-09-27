package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AjaxSettings that = (AjaxSettings) o;

        return new EqualsBuilder()
                .append(chat, that.chat)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(chat)
                .toHashCode();
    }

    @Override

    public final String toString() {
        return "settings{" +
                "chat=" + this.chat +
                '}';
    }
}
