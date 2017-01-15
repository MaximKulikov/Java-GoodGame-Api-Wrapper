package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmileUrls {

    private String img;

    private String big;

    private String gif;

    public final String getBig() {
        return this.big;
    }

    public final void setBig(final String big) {
        this.big = big;
    }

    public final String getGif() {
        return this.gif;
    }

    public final void setGif(final String gif) {
        this.gif = gif;
    }

    public final String getImg() {
        return this.img;
    }

    public final void setImg(final String img) {
        this.img = img;
    }

    @Override
    public final String toString() {
        return "SmileUrls{" +
                "img='" + this.img + '\'' +
                ", big='" + this.big + '\'' +
                ", gif='" + this.gif + '\'' +
                '}';
    }
}
