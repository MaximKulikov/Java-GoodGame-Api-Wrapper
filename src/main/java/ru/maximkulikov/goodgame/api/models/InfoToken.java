package ru.maximkulikov.goodgame.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoToken {

    private List<String> scopes;

    private String expires;

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
