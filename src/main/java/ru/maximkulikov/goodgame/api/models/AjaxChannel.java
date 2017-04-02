package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 03.04.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxChannel {

    private String id;

    private String link;

    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

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
}

