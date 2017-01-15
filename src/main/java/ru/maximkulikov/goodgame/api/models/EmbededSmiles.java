package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededSmiles {

    private List<Smile> smiles;

    public final List<Smile> getSmiles() {
        return smiles;
    }

    public final void setSmiles(final List<Smile> smiles) {
        this.smiles = smiles;
    }

    @Override
    public final String toString() {
        return "EmbededSmiles{" +
                "smiles=" + smiles +
                '}';
    }
}
