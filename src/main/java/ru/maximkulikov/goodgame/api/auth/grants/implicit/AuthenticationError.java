package ru.maximkulikov.goodgame.api.auth.grants.implicit;

/**
 * The <code>AuthenticationError</code> class represents an error during
 * authentication with <a href="http://twitch.tv">http://www.twitch.tv</a>.
 */
public class AuthenticationError {

    // the name of the error
    private final String name;

    // the description of the error
    private final String description;

    public AuthenticationError(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + (this.description != null ? this.description.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AuthenticationError that = (AuthenticationError) o;

        if (this.name != null ? !this.name.equals(that.name) : that.name != null) {
            return false;
        }
        return !(this.description != null ? !this.description.equals(that.description) : that.description != null);

    }

    @Override
    public final String toString() {
        return "AuthenticationError{" +
                "name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                '}';
    }
}