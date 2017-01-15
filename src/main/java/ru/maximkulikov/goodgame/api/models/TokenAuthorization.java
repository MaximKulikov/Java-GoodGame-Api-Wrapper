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
        return this.createdAt;
    }

    public final void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public final List<Scopes> getScopes() {
        return this.scopes;
    }

    public final void setScopes(final List<String> scopes) {
        this.scopes = new ArrayList<>();
        for (String s : scopes) {
            this.scopes.add(Scopes.fromString(s));
        }
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public final int hashCode() {
        int result = this.scopes != null ? this.scopes.hashCode() : 0;
        result = 31 * result + (this.createdAt != null ? this.createdAt.hashCode() : 0);
        result = 31 * result + (this.updatedAt != null ? this.updatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TokenAuthorization that = (TokenAuthorization) o;

        if (this.scopes != null ? !this.scopes.equals(that.scopes) : that.scopes != null) {
            return false;
        }
        if (this.createdAt != null ? !this.createdAt.equals(that.createdAt) : that.createdAt != null) {
            return false;
        }
        return !(this.updatedAt != null ? !this.updatedAt.equals(that.updatedAt) : that.updatedAt != null);
    }

    @Override
    public final String toString() {
        return "TokenAuthorization{" +
                "scopes=" + this.scopes +
                ", createdAt=" + this.createdAt +
                ", updatedAt=" + this.updatedAt +
                '}';
    }
}
