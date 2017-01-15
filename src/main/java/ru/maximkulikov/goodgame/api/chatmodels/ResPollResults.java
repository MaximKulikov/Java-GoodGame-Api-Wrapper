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

    public final List<PollResult> getAnswers() {
        return answers;
    }

    public final void setAnswers(final List<PollResult> answers) {
        this.answers = answers;
    }

    public final String getChannelId() {
        return channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final Long getVoters() {
        return voters;
    }

    public final void setVoters(final Long voters) {
        this.voters = voters;
    }

    @Override
    public final String toString() {
        return "ResPollResults{" +
                "channelId='" + channelId + '\'' +
                ", voters=" + voters +
                ", title='" + title + '\'' +
                ", answers=" + answers +
                '}';
    }
}
