package ru.maximkulikov.goodgame.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededSubscribers {

    private List<Subscrurer> subscribers;

    /**
     * @return subscribers
     */
    public final List<Subscrurer> getSubscribers() {
        return this.subscribers;
    }

    public final void setSubscribers(final List<Subscrurer> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EmbededSubscribers that = (EmbededSubscribers) o;

        return new EqualsBuilder()
                .append(subscribers, that.subscribers)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(subscribers)
                .toHashCode();
    }

    @Override
    public final String toString() {
        return "EmbededSubscribers{" +
                "subscribers=" + this.subscribers +
                '}';
    }
}
