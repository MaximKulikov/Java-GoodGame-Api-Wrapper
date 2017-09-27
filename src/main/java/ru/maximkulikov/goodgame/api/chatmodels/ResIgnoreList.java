package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResIgnoreList implements ResChatObject {

    private List<ChatUser> users;

    public final List<ChatUser> getUsers() {
        return this.users;
    }

    public final void setUsers(final List<ChatUser> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResIgnoreList that = (ResIgnoreList) o;

        return new EqualsBuilder()
                .append(users, that.users)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(users)
                .toHashCode();
    }

    @Override
    public final String toString() {
        return "ResIgnoreList{" +
                "users=" + this.users +
                '}';
    }
}
