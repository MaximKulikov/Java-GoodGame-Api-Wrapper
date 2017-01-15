package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubSubscribers {

    private Boolean success;

    private List<GitHubSubscriber> response;

    public final List<GitHubSubscriber> getResponse() {
        return response;
    }

    public final void setResponse(final List<GitHubSubscriber> response) {
        this.response = response;
    }

    public final Boolean getSuccess() {
        return success;
    }

    public final void setSuccess(final Boolean success) {
        this.success = success;
    }

    @Override
    public final String toString() {
        return "GitHubSubscribers{" +
                "success=" + success +
                ", response=" + response +
                '}';
    }
}
