package ru.maximkulikov.goodgame.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubSubscribers {

    private Boolean success;

    private List<GitHubSubscriber> response;

    /**
     * @return response
     */
    public final List<GitHubSubscriber> getResponse() {
        return this.response;
    }

    public final void setResponse(final List<GitHubSubscriber> response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GitHubSubscribers that = (GitHubSubscribers) o;

        return new EqualsBuilder()
                .append(success, that.success)
                .append(response, that.response)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(success)
                .append(response)
                .toHashCode();
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
        return "GitHubSubscribers{" +
                "success=" + this.success +
                ", response=" + this.response +
                '}';
    }
}
