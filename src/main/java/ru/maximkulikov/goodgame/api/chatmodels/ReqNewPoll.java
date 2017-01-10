package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqNewPoll {
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("moder_id")
    private String moderId;
    @JsonProperty("moder_name")
    private String moderName;
    private String title;
    private List<PollAnswer> answers;

    public ReqNewPoll(String channelId, String moderId, String moderName, String title, List<String> answers) {
        this.channelId = channelId;
        this.moderId = moderId;
        this.moderName = moderName;
        this.title = title;
        List<PollAnswer> pollAnswers = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            pollAnswers.add(new PollAnswer(i + 1, answers.get(i)));
        }

        this.answers = pollAnswers;
    }

    public List<PollAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<PollAnswer> answers) {
        this.answers = answers;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getModerId() {
        return moderId;
    }

    public void setModerId(String moderId) {
        this.moderId = moderId;
    }

    public String getModerName() {
        return moderName;
    }

    public void setModerName(String moderName) {
        this.moderName = moderName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ReqNewPoll{" +
                "channelId='" + channelId + '\'' +
                ", moderId='" + moderId + '\'' +
                ", moderName='" + moderName + '\'' +
                ", title='" + title + '\'' +
                ", answers=" + answers +
                '}';
    }
}

