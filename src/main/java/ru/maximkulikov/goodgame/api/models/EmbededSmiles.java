package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededSmiles {
    private List<Smile> smiles;

    @Override
    public String toString() {
        return "EmbededSmiles{" +
                "smiles=" + smiles +
                '}';
    }

    public List<Smile> getSmiles() {
        return smiles;
    }

    public void setSmiles(List<Smile> smiles) {
        this.smiles = smiles;
    }
}
