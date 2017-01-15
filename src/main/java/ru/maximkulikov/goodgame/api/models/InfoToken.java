package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoToken {

    private List<String> scopes;

    private String expires;

    public final String getExpires() {
        return expires;
    }

    public final void setExpires(final String expires) {
        this.expires = expires;
    }

    public final List<String> getScopes() {
        return scopes;
    }

    public final void setScopes(final List<String> scopes) {
        this.scopes = scopes;
    }

    @Override
    public final String toString() {
        return "InfoToken{" +
                "scopes=" + scopes +
                ", expires='" + expires + '\'' +
                '}';
    }
}
