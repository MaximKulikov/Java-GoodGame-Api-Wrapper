package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PremiumPrices {

    @JsonProperty("1")
    private String id1;

    @JsonProperty("2")
    private String id2;

    @JsonProperty("3")
    private String id3;

    @JsonProperty("4")
    private String id4;

    @JsonProperty("5")
    private String id5;

    public final String getId1() {
        return this.id1;
    }

    public final void setId1(final String id1) {
        this.id1 = id1;
    }

    public final String getId2() {
        return this.id2;
    }

    public final void setId2(final String id2) {
        this.id2 = id2;
    }

    public final String getId3() {
        return this.id3;
    }

    public final void setId3(final String id3) {
        this.id3 = id3;
    }

    public final String getId4() {
        return this.id4;
    }

    public final void setId4(final String id4) {
        this.id4 = id4;
    }

    public final String getId5() {
        return this.id5;
    }

    public final void setId5(final String id5) {
        this.id5 = id5;
    }

    @Override
    public final String toString() {
        return "PremiumPrices{" +
                "id1='" + this.id1 + '\'' +
                ", id2='" + this.id2 + '\'' +
                ", id3='" + this.id3 + '\'' +
                ", id4='" + this.id4 + '\'' +
                ", id5='" + this.id5 + '\'' +
                '}';
    }
}
