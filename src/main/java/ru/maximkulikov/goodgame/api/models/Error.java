package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Matthew Bell
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

    @JsonProperty("title")
    private String statusText;

    @JsonProperty("status")
    private int statusCode;

    @JsonProperty("detail")
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Error error = (Error) o;

        return new EqualsBuilder()
                .append(statusCode, error.statusCode)
                .append(statusText, error.statusText)
                .append(message, error.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(statusText)
                .append(statusCode)
                .append(message)
                .toHashCode();
    }

    /**
     * @return detail
     */
    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @return status
     */
    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return title
     */
    public final String getStatusText() {

        return this.statusText;
    }

    public final void setStatusText(final String statusText) {
        this.statusText = statusText;
    }

    @Override
    public final String toString() {
        return "Error{" +
                "statusText='" + this.statusText + '\'' +
                ", statusCode=" + this.statusCode +
                ", message='" + this.message + '\'' +
                '}';
    }
}
