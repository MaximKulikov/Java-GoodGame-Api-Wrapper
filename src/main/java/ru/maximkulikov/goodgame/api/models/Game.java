package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    private String id;

    private String title;

    private String url;

    @JsonProperty("short")
    private String shortTitle;

    private String poster;

    public final String getId() {
        return id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getPoster() {
        return poster;
    }

    public final void setPoster(final String poster) {
        this.poster = poster;
    }

    public final String getShortTitle() {
        return shortTitle;
    }

    public final void setShortTitle(final String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String getUrl() {
        return url;
    }

    public final void setUrl(final String url) {
        this.url = url;
    }

    @Override
    public final String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", shortTitle='" + shortTitle + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
