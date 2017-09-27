package ru.maximkulikov.goodgame.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EmbededSmiles that = (EmbededSmiles) o;

        return new EqualsBuilder()
                .append(smiles, that.smiles)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(smiles)
                .toHashCode();
    }

    @Override
    public final String toString() {
        return "EmbededSmiles{" +
                "smiles=" + this.smiles +
                '}';
    }
}
