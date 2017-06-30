package ru.maximkulikov.goodgame.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededSmiles {

    private List<Smile> smiles;

    /**
     * @return smiles
     */
    public final List<Smile> getSmiles() {
        return this.smiles;
    }

    public final void setSmiles(final List<Smile> smiles) {
        this.smiles = smiles;
    }

    @Override
    public final String toString() {
        return "EmbededSmiles{" +
                "smiles=" + this.smiles +
                '}';
    }
}
