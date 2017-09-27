package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    private String id;

    private String title;

    private String url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return new EqualsBuilder()
                .append(id, game.id)
                .append(title, game.title)
                .append(url, game.url)
                .append(shortTitle, game.shortTitle)
                .append(poster, game.poster)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .append(url)
                .append(shortTitle)
                .append(poster)
                .toHashCode();
    }

    @JsonProperty("short")
    private String shortTitle;

    private String poster;

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
     * @return poster
     */
    public final String getPoster() {
        return this.poster;
    }

    public final void setPoster(final String poster) {
        this.poster = poster;
    }

    /**
     * @return short
     */
    public final String getShortTitle() {
        return this.shortTitle;
    }

    public final void setShortTitle(final String shortTitle) {
        this.shortTitle = shortTitle;
    }

    /**
     * @return title
     */
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return url
     */
    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(final String url) {
        this.url = url;
    }

    @Override
    public final String toString() {
        return "Game{" +
                "id='" + this.id + '\'' +
                ", title='" + this.title + '\'' +
                ", url='" + this.url + '\'' +
                ", shortTitle='" + this.shortTitle + '\'' +
                ", poster='" + this.poster + '\'' +
                '}';
    }
}
