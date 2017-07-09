package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqVoteContainer implements ReqChatObject {

    private String type = "vote";

    private ReqVote data;

    /**
     * @param channelId channel_id
     * @param answerId  answer_id
     */
    public ReqVoteContainer(final String channelId, final int answerId) {
        this.data = new ReqVote(channelId, answerId);
    }

    public final ReqVote getData() {
        return this.data;
    }

    public final void setData(final ReqVote data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqVoteContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
