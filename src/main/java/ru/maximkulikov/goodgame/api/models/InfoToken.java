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

    @Override
    public String toString() {
        return "InfoToken{" +
                "scopes=" + scopes +
                ", expires='" + expires + '\'' +
                '}';
    }

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }
}
