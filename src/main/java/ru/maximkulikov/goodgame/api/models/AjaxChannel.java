package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 03.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxChannel {

    private String id;

    private String link;

    /**
     * @return id
     */
    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * @return link
     */
    public final String getLink() {
        return this.link;
    }

    public final void setLink(final String link) {
        this.link = link;
    }

    @Override
    public final String toString() {
        return "channel{" +
                "id='" + this.id + '\'' +
                ", link='" + this.link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AjaxChannel that = (AjaxChannel) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(link, that.link)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(link)
                .toHashCode();
    }
}

