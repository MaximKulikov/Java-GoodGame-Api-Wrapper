package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 03.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxChat {

    private Integer alignType;

    private Integer pekaMod;

    private Boolean sound;

    private Integer smilesType;

    private Integer hide;

    private Boolean noBan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AjaxChat ajaxChat = (AjaxChat) o;

        return new EqualsBuilder()
                .append(alignType, ajaxChat.alignType)
                .append(pekaMod, ajaxChat.pekaMod)
                .append(sound, ajaxChat.sound)
                .append(smilesType, ajaxChat.smilesType)
                .append(hide, ajaxChat.hide)
                .append(noBan, ajaxChat.noBan)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(alignType)
                .append(pekaMod)
                .append(sound)
                .append(smilesType)
                .append(hide)
                .append(noBan)
                .toHashCode();
    }

    /**
     * @return alignType
     */
    public final Integer getAlignType() {
        return this.alignType;
    }

    public final void setAlignType(final Integer alignType) {
        this.alignType = alignType;
    }

    /**
     * @return pekaMod
     */
    public final Integer getPekaMod() {
        return this.pekaMod;
    }

    public final void setPekaMod(final Integer pekaMod) {
        this.pekaMod = pekaMod;
    }

    /**
     * @return sound
     */
    public final Boolean getSound() {
        return this.sound;
    }

    public final void setSound(final Boolean sound) {
        this.sound = sound;
    }

    /**
     * @return smilesType
     */
    public final Integer getSmilesType() {
        return this.smilesType;
    }

    public final void setSmilesType(final Integer smilesType) {
        this.smilesType = smilesType;
    }

    /**
     * @return hide
     */
    public final Integer getHide() {
        return this.hide;
    }

    public final void setHide(final Integer hide) {
        this.hide = hide;
    }

    /**
     * @return noBan
     */
    public Boolean getNoBan() {
        return this.noBan;
    }

    public void setNoBan(final Boolean noBan) {
        this.noBan = noBan;
    }

    @Override
    public final String toString() {
        return "chat{" +
                "alignType=" + this.alignType +
                ", pekaMod=" + this.pekaMod +
                ", sound=" + this.sound +
                ", smilesType=" + this.smilesType +
                ", hide=" + this.hide +
                ", noBan=" + this.noBan +
                '}';
    }
}
