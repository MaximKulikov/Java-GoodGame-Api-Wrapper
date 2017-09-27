package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResPayment implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private String userName;

    private Long amount;

    private String message;

    private Long total;

    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResPayment that = (ResPayment) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(userName, that.userName)
                .append(amount, that.amount)
                .append(message, that.message)
                .append(total, that.total)
                .append(title, that.title)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(userName)
                .append(amount)
                .append(message)
                .append(total)
                .append(title)
                .toHashCode();
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final void setAmount(final Long amount) {
        this.amount = amount;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(final String message) {
        this.message = message;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final Long getTotal() {
        return this.total;
    }

    public final void setTotal(final Long total) {
        this.total = total;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public final String toString() {
        return "ResPayment{" +
                "channelId='" + this.channelId + '\'' +
                ", userName='" + this.userName + '\'' +
                ", amount=" + this.amount +
                ", message='" + this.message + '\'' +
                ", total=" + this.total +
                ", title='" + this.title + '\'' +
                '}';
    }
}
