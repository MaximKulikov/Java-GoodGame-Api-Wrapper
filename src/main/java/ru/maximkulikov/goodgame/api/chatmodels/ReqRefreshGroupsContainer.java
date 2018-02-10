package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 14.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRefreshGroupsContainer implements ReqChatObject {

    private String type = "refresh_premium";

    private ReqGetPoll data;

    /**
     * @param channelId channel_id
     */
    public ReqRefreshGroupsContainer(final String channelId) {
        this.data = new ReqGetPoll(channelId);
    }

}
