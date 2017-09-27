package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqNewPoll {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("moder_id")
    private String moderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ReqNewPoll that = (ReqNewPoll) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(moderId, that.moderId)
                .append(moderName, that.moderName)
                .append(title, that.title)
                .append(answers, that.answers)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(moderId)
                .append(moderName)
                .append(title)
                .append(answers)
                .toHashCode();
    }

    @JsonProperty("moder_name")
    private String moderName;

    private String title;

    private List<PollAnswer> answers;

    /**
     * @param channelId channel_id
     * @param moderId   moder_id
     * @param moderName moder_name
     * @param title     title
     * @param answers   answers
     */
    public ReqNewPoll(final String channelId, final String moderId, final String moderName,
                      final String title, final List<String> answers) {
        this.channelId = channelId;
        this.moderId = moderId;
        this.moderName = moderName;
        this.title = title;
        List<PollAnswer> pollAnswers = new ArrayList<>();

        for (int i = 0; i < answers.size(); i++) {
            PollAnswer pollAnswer = new PollAnswer();
            pollAnswer.setId(i + 1);
            pollAnswer.setText(answers.get(i));
            pollAnswers.add(pollAnswer);
        }

        this.answers = pollAnswers;
    }

    public final List<PollAnswer> getAnswers() {
        return this.answers;
    }

    public final void setAnswers(final List<PollAnswer> answers) {
        this.answers = answers;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getModerId() {
        return this.moderId;
    }

    public final void setModerId(final String moderId) {
        this.moderId = moderId;
    }

    public final String getModerName() {
        return this.moderName;
    }

    public final void setModerName(final String moderName) {
        this.moderName = moderName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public final String toString() {
        return "ReqNewPoll{" +
                "channelId='" + this.channelId + '\'' +
                ", moderId='" + this.moderId + '\'' +
                ", moderName='" + this.moderName + '\'' +
                ", title='" + this.title + '\'' +
                ", answers=" + this.answers +
                '}';
    }
}
