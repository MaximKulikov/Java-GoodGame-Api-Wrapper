package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OauthResourceCheck {

    private Boolean success;

    private String message;

    /**
     * @return message
     */
    public final String getMessage() {
        return this.message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OauthResourceCheck that = (OauthResourceCheck) o;

        return new EqualsBuilder()
                .append(success, that.success)
                .append(message, that.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(success)
                .append(message)
                .toHashCode();
    }

    public final void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @return success
     */
    public final Boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(final Boolean success) {
        this.success = success;
    }

    @Override
    public final String toString() {
        return "OauthResource{" +
                "success=" + this.success +
                ", message='" + this.message + '\'' +
                '}';
    }
}
