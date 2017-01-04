package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubSubscribers {
    private Boolean success;
    private List<GitHubSubscriber> response;

    public List<GitHubSubscriber> getResponse() {
        return response;
    }

    public void setResponse(List<GitHubSubscriber> response) {
        this.response = response;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "GitHubSubscribers{" +
                "success=" + success +
                ", response=" + response +
                '}';
    }
}
