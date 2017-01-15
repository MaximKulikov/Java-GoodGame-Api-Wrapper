package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

    private String userName;

    private boolean valid;

    private TokenAuthorization authorization;

    public final TokenAuthorization getAuthorization() {
        return this.authorization;
    }

    public final void setAuthorization(final TokenAuthorization authorization) {
        this.authorization = authorization;
    }

    public final String getUserName() {

        return this.userName;
    }

    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public final int hashCode() {
        return this.userName != null ? this.userName.hashCode() : 0;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Token token = (Token) o;

        return !(this.userName != null ? !this.userName.equals(token.userName) : token.userName != null);

    }

    @Override
    public final String toString() {
        return "Token{" +
                "userName='" + this.userName + '\'' +
                ", valid=" + this.valid +
                ", authorization=" + this.authorization +
                '}';
    }

    public final boolean isValid() {
        return this.valid;
    }

    public final void setValid(final boolean valid) {
        this.valid = valid;
    }
}
