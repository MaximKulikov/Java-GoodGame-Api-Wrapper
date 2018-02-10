package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqGetPollContainer implements ReqChatObject {

    private String type = "get_poll";

    private ReqGetPoll data;

    /**
     * @param channelId channel_id
     */
    public ReqGetPollContainer(final String channelId) {
        this.data = new ReqGetPoll(channelId);
    }

}
