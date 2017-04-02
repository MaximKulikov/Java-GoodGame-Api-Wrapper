package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 03.04.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxChat {

    private Integer alignType;

    private Integer pekaMod;

    private Boolean sound;

    private Integer smilesType;

    private Integer hide;

    private Boolean noBan;

    public final Integer getAlignType() {
        return this.alignType;
    }

    public final void setAlignType(final Integer alignType) {
        this.alignType = alignType;
    }

    public final Integer getPekaMod() {
        return this.pekaMod;
    }

    public final void setPekaMod(final Integer pekaMod) {
        this.pekaMod = pekaMod;
    }

    public final Boolean getSound() {
        return this.sound;
    }

    public final void setSound(final Boolean sound) {
        this.sound = sound;
    }

    public final Integer getSmilesType() {
        return this.smilesType;
    }

    public final void setSmilesType(final Integer smilesType) {
        this.smilesType = smilesType;
    }

    public final Integer getHide() {
        return this.hide;
    }

    public final void setHide(final Integer hide) {
        this.hide = hide;
    }

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
