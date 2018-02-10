package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@Data
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

}
