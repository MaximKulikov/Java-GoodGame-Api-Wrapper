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

    @Override
    public String toString() {
        return "PremiumPrices{" +
                "id1='" + id1 + '\'' +
                ", id2='" + id2 + '\'' +
                ", id3='" + id3 + '\'' +
                ", id4='" + id4 + '\'' +
                ", id5='" + id5 + '\'' +
                '}';
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getId3() {
        return id3;
    }

    public void setId3(String id3) {
        this.id3 = id3;
    }

    public String getId4() {
        return id4;
    }

    public void setId4(String id4) {
        this.id4 = id4;
    }

    public String getId5() {
        return id5;
    }

    public void setId5(String id5) {
        this.id5 = id5;
    }
}
