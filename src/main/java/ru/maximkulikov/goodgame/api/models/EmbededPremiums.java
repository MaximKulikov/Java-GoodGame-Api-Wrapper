package ru.maximkulikov.goodgame.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededPremiums {

    private List<Premium> premiums;

    /**
     * @return premiums
     */
    public final List<Premium> getPremiums() {
        return this.premiums;
    }

    public final void setPremiums(final List<Premium> premiums) {
        this.premiums = premiums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EmbededPremiums that = (EmbededPremiums) o;

        return new EqualsBuilder()
                .append(premiums, that.premiums)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(premiums)
                .toHashCode();
    }

    @Override

    public final String toString() {
        return "EmbededPremiums{" +
                "premiums=" + this.premiums +
                '}';
    }
}
