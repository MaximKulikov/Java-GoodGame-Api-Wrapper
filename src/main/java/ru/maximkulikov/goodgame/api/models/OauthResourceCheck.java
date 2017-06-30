package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
