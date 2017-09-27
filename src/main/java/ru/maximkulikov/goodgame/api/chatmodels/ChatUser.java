package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatUser implements ResChatObject {

    private String id;

    private String name;

    private Long right;

    private Boolean premium;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ChatUser chatUser = (ChatUser) o;

        return new EqualsBuilder()
                .append(id, chatUser.id)
                .append(name, chatUser.name)
                .append(right, chatUser.right)
                .append(premium, chatUser.premium)
                .append(payments, chatUser.payments)
                .append(mobile, chatUser.mobile)
                .append(hidden, chatUser.hidden)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(right)
                .append(premium)
                .append(payments)
                .append(mobile)
                .append(hidden)
                .toHashCode();
    }

    private String payments;

    private Boolean mobile;

    private Boolean hidden;

    /**
     * @return hidden
     */
    public final Boolean getHidden() {
        return this.hidden;
    }

    public final void setHidden(final Boolean hidden) {
        this.hidden = hidden;
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
     * @return mobile
     */
    public final Boolean getMobile() {
        return this.mobile;
    }

    public final void setMobile(final Boolean mobile) {
        this.mobile = mobile;
    }

    /**
     * @return name
     */
    public final String getName() {
        return this.name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @return payments
     */
    public final String getPayments() {
        return this.payments;
    }

    public final void setPayments(final String payments) {
        this.payments = payments;
    }

    /**
     * @return premium
     */
    public final Boolean getPremium() {
        return this.premium;
    }

    public final void setPremium(final Boolean premium) {
        this.premium = premium;
    }

    /**
     * @return right
     */
    public final Long getRight() {
        return this.right;
    }

    public final void setRight(final Long right) {
        this.right = right;
    }

    @Override
    public final String toString() {
        return "ChatUser{" +
                "id='" + this.id + '\'' +
                ", name='" + this.name + '\'' +
                ", right=" + this.right +
                ", premium=" + this.premium +
                ", payments='" + this.payments + '\'' +
                ", mobile=" + this.mobile +
                ", hidden=" + this.hidden +
                '}';
    }
}
