package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 20.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResAcceptedContainer {

    private String type;

    private ResAccepted data;

    public final ResAccepted getData() {
        return this.data;
    }

    public final void setData(final ResAccepted data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResAcceptedContainer that = (ResAcceptedContainer) o;

        return new EqualsBuilder()
                .append(type, that.type)
                .append(data, that.data)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(type)
                .append(data)
                .toHashCode();
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ResAcceptedContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
