package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqVote {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("answer_id")
    private int answerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ReqVote reqVote = (ReqVote) o;

        return new EqualsBuilder()
                .append(answerId, reqVote.answerId)
                .append(channelId, reqVote.channelId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(answerId)
                .toHashCode();
    }

    /**
     * @param channelId channel_id
     * @param answerId  answer_id
     */
    public ReqVote(final String channelId, final int answerId) {
        this.channelId = channelId;
        this.answerId = answerId;
    }

    public final int getAnswerId() {
        return this.answerId;
    }

    public final void setAnswerId(final int answerId) {
        this.answerId = answerId;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    @Override
    public final String toString() {
        return "ReqVote{" +
                "channelId='" + this.channelId + '\'' +
                ", answerId=" + this.answerId +
                '}';
    }
}
