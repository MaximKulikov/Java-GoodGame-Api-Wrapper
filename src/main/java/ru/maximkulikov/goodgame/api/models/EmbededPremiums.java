package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 03.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededPremiums {

    private List<Premium> premiums;

    public final List<Premium> getPremiums() {
        return this.premiums;
    }

    public final void setPremiums(final List<Premium> premiums) {
        this.premiums = premiums;
    }

    @Override
    public final String toString() {
        return "EmbededPremiums{" +
                "premiums=" + this.premiums +
                '}';
    }
}
