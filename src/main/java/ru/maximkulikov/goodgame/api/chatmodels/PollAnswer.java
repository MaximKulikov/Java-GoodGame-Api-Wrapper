package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollAnswer {

    private int id;

    private String text;

    /**
     * @return id
     */
    public final int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PollAnswer that = (PollAnswer) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(text, that.text)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(text)
                .toHashCode();
    }

    public final void setId(final int id) {
        this.id = id;
    }

    /**
     * @return text
     */
    public final String getText() {
        return this.text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    @Override
    public final String toString() {
        return "PollAnswer{" +
                "id='" + this.id + '\'' +
                ", text='" + this.text + '\'' +
                '}';
    }
}
