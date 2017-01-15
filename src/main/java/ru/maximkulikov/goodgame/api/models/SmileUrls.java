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
        return big;
    }

    public final void setBig(final String big) {
        this.big = big;
    }

    public final String getGif() {
        return gif;
    }

    public final void setGif(final String gif) {
        this.gif = gif;
    }

    public final String getImg() {
        return img;
    }

    public final void setImg(final String img) {
        this.img = img;
    }

    @Override
    public final String toString() {
        return "SmileUrls{" +
                "img='" + img + '\'' +
                ", big='" + big + '\'' +
                ", gif='" + gif + '\'' +
                '}';
    }
}
