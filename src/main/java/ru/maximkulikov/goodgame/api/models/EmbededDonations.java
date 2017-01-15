package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededDonations {

    private String id;

    private String username;

    private String amount;

    @JsonProperty("paid_date")
    private String paidDate;

    private String comment;

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(final String amount) {
        this.amount = amount;
    }

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(final String comment) {
        this.comment = comment;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getPaidDate() {
        return this.paidDate;
    }

    public final void setPaidDate(final String paidDate) {
        this.paidDate = paidDate;
    }

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
