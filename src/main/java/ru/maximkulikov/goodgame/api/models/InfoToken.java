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
public class InfoToken {

    private List<String> scopes;

    private String expires;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        InfoToken infoToken = (InfoToken) o;

        return new EqualsBuilder()
                .append(scopes, infoToken.scopes)
                .append(expires, infoToken.expires)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(scopes)
                .append(expires)
                .toHashCode();
    }

    /**
     * @return expires
     */
    public final String getExpires() {
        return this.expires;
    }

    public final void setExpires(final String expires) {
        this.expires = expires;
    }

    /**
     * @return scopes
     */
    public final List<String> getScopes() {
        return this.scopes;
    }

    public final void setScopes(final List<String> scopes) {
        this.scopes = scopes;
    }

    @Override
    public final String toString() {
        return "InfoToken{" +
                "scopes=" + this.scopes +
                ", expires='" + this.expires + '\'' +
                '}';
    }
}
