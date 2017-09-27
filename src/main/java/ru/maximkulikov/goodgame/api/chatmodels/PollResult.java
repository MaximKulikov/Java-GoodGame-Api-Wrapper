package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollResult {

    private int id;

    private String text;

    private Long voters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PollResult that = (PollResult) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(text, that.text)
                .append(voters, that.voters)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(text)
                .append(voters)
                .toHashCode();
    }

    /**
     * @return id
     */
    public final int getId() {
        return this.id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    /**
     * @return text
     */
    public final String getText() {
        return this.text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    /**
     * @return voters
     */
    public final Long getVoters() {
        return this.voters;
    }

    public final void setVoters(final Long voters) {
        this.voters = voters;
    }

    @Override
    public final String toString() {
        return "PollResult{" +
                "id=" + this.id +
                ", text='" + this.text + '\'' +
                ", voters=" + this.voters +
                '}';
    }
}
