package ru.maximkulikov.goodgame.api.chatmodels;

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
public class ResPollResults implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private Long voters;

    private String title;

    private List<PollResult> answers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResPollResults that = (ResPollResults) o;

        return new EqualsBuilder()
                .append(channelId, that.channelId)
                .append(voters, that.voters)
                .append(title, that.title)
                .append(answers, that.answers)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(voters)
                .append(title)
                .append(answers)
                .toHashCode();
    }

    public final List<PollResult> getAnswers() {
        return this.answers;
    }

    public final void setAnswers(final List<PollResult> answers) {
        this.answers = answers;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final Long getVoters() {
        return this.voters;
    }

    public final void setVoters(final Long voters) {
        this.voters = voters;
    }

    @Override
    public final String toString() {
        return "ResPollResults{" +
                "channelId='" + this.channelId + '\'' +
                ", voters=" + this.voters +
                ", title='" + this.title + '\'' +
                ", answers=" + this.answers +
                '}';
    }
}
