package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmileUrls {

    private String img;

    private String big;

    private String gif;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SmileUrls smileUrls = (SmileUrls) o;

        return new EqualsBuilder()
                .append(img, smileUrls.img)
                .append(big, smileUrls.big)
                .append(gif, smileUrls.gif)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(img)
                .append(big)
                .append(gif)
                .toHashCode();
    }

    /**
     * @return big

     */
    public final String getBig() {
        return this.big;
    }

    public final void setBig(final String big) {
        this.big = big;
    }

    /**
     * @return gif
     */
    public final String getGif() {
        return this.gif;
    }

    public final void setGif(final String gif) {
        this.gif = gif;
    }

    /**
     * @return img
     */
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
