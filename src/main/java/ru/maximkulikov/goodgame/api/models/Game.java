package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    private String id;

    private String title;

    private String url;

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
