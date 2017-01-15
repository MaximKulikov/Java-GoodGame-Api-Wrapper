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
        return amount;
    }

    public final void setAmount(final String amount) {
        this.amount = amount;
    }

    public final String getComment() {
        return comment;
    }

    public final void setComment(final String comment) {
        this.comment = comment;
    }

    public final String getId() {
        return id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getPaidDate() {
        return paidDate;
    }

    public final void setPaidDate(final String paidDate) {
        this.paidDate = paidDate;
    }

    public final String getUsername() {
        return username;
    }

    public final void setUsername(final String username) {
        this.username = username;
    }

    @Override
    public final String toString() {
        return "EmbededDonations{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", amount='" + amount + '\'' +
                ", paidDate='" + paidDate + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
