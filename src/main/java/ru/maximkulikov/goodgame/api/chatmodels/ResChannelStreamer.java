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
public class ResChannelStreamer implements ResChatObject {

    private Long id;

    private String name;

    private Long right;

    private List<String> groups;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResChannelStreamer that = (ResChannelStreamer) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(name, that.name)
                .append(right, that.right)
                .append(groups, that.groups)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(right)
                .append(groups)
                .toHashCode();
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final void setGroups(final List<String> groups) {
        this.groups = groups;
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final Long getRight() {
        return this.right;
    }

    public final void setRight(final Long right) {
        this.right = right;
    }

    @Override
    public final String toString() {
        return "ResChannelStreamer{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", right=" + this.right +
                ", groups=" + this.groups +
                '}';
    }
}
