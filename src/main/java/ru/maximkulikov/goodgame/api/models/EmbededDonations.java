package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededDonations {

    private String id;

    private String username;

    private String amount;

    @JsonProperty("paid_date")
    private String paidDate;

    private String comment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EmbededDonations that = (EmbededDonations) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(username, that.username)
                .append(amount, that.amount)
                .append(paidDate, that.paidDate)
                .append(comment, that.comment)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(username)
                .append(amount)
                .append(paidDate)
                .append(comment)
                .toHashCode();
    }

    /**
     * @return amount
     */
    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(final String amount) {
        this.amount = amount;
    }

    /**
     * @return comment
     */
    public final String getComment() {
        return this.comment;
    }

    public final void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * @return id
     */
    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * @return paid_date
     */
    public final String getPaidDate() {
        return this.paidDate;
    }

    public final void setPaidDate(final String paidDate) {
        this.paidDate = paidDate;
    }

    /**
     * @return username
     */
    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(final String username) {
        this.username = username;
    }

    @Override
    public final String toString() {
        return "EmbededDonations{" +
                "id='" + this.id + '\'' +
                ", username='" + this.username + '\'' +
                ", amount='" + this.amount + '\'' +
                ", paidDate='" + this.paidDate + '\'' +
                ", comment='" + this.comment + '\'' +
                '}';
    }
}
