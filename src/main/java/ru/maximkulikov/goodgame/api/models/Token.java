package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

    private String userName;

    private boolean valid;

    private TokenAuthorization authorization;

    public final TokenAuthorization getAuthorization() {
        return authorization;
    }

    public final void setAuthorization(final TokenAuthorization authorization) {
        this.authorization = authorization;
    }

    public final String getUserName() {

        return userName;
    }

    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        return !(userName != null ? !userName.equals(token.userName) : token.userName != null);

    }

    @Override
    public final String toString() {
        return "Token{" +
                "userName='" + userName + '\'' +
                ", valid=" + valid +
                ", authorization=" + authorization +
                '}';
    }

    public final boolean isValid() {
        return valid;
    }

    public final void setValid(final boolean valid) {
        this.valid = valid;
    }
}
