package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResPollResults implements ResChatObject {
    @JsonProperty("channel_id")
    private String channelId;
    private Long voters;
    private String title;
    private List<PollResult> answers;

    @Override
    public String toString() {
        return "ResPollResults{" +
                "channelId='" + channelId + '\'' +
                ", voters=" + voters +
                ", title='" + title + '\'' +
                ", answers=" + answers +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Long getVoters() {
        return voters;
    }

    public void setVoters(Long voters) {
        this.voters = voters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PollResult> getAnswers() {
        return answers;
    }

    public void setAnswers(List<PollResult> answers) {
        this.answers = answers;
    }
}
