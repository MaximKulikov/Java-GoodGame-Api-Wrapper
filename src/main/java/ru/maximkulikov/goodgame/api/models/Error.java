package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

    @JsonProperty("title")
    private String statusText;

    @JsonProperty("status")
    private int statusCode;

    @JsonProperty("detail")
    private String message;

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(final String message) {
        this.message = message;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    public final String getStatusText() {

        return this.statusText;
    }

    public final void setStatusText(final String statusText) {
        this.statusText = statusText;
    }

    @Override
    public final int hashCode() {
        int result = this.statusText != null ? this.statusText.hashCode() : 0;
        result = 31 * result + this.statusCode;
        result = 31 * result + (this.message != null ? this.message.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Error that = (Error) o;

        if (this.statusCode != that.statusCode) {
            return false;
        }
        if (this.statusText != null ? !this.statusText.equals(that.statusText) : that.statusText != null) {
            return false;
        }
        return !(this.message != null ? !this.message.equals(that.message) : that.message != null);

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
