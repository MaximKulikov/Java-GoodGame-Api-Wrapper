package ru.maximkulikov.goodgame.api.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.maximkulikov.goodgame.api.auth.Scopes;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenAuthorization {

    private List<Scopes> scopes;

    private Date createdAt;

    private Date updatedAt;

    public final Date getCreatedAt() {
        return createdAt;
    }

    public final void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public final List<Scopes> getScopes() {
        return scopes;
    }

    public final void setScopes(final List<String> scopes) {
        this.scopes = new ArrayList<>();
        for (String s : scopes) {
            this.scopes.add(Scopes.fromString(s));
        }
    }

    public final Date getUpdatedAt() {
        return updatedAt;
    }

    public final void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        int result = scopes != null ? scopes.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokenAuthorization that = (TokenAuthorization) o;

        if (scopes != null ? !scopes.equals(that.scopes) : that.scopes != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        return !(updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null);
    }

    @Override
    public final String toString() {
        return "TokenAuthorization{" +
                "scopes=" + scopes +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
