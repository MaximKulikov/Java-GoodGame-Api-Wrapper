package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqMakeModeratorContainer implements ReqChatObject {

    private String type = "make_moderator";

    private ReqMakeModerator data;

    /**
     * @param channelId channel_id
     * @param userId    user_id
     */
    public ReqMakeModeratorContainer(final String channelId, final String userId) {
        this.data = new ReqMakeModerator(channelId, userId);
    }

}
