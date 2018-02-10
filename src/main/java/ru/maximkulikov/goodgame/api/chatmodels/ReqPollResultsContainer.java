package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqPollResultsContainer implements ReqChatObject {

    private String type = "get_poll_results";

    private ReqGetPoll data;

    /**
     * @param channelId channel_id
     */
    public ReqPollResultsContainer(final String channelId) {
        this.data = new ReqGetPoll(channelId);
    }

}
