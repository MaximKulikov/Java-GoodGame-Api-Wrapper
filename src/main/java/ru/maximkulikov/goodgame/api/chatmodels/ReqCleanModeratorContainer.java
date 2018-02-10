package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqCleanModeratorContainer implements ReqChatObject {

    private String type = "clean_moderator";

    private ReqMakeModerator data;

    /**
     * @param channelId channel_id
     * @param userId    user_id
     */
    public ReqCleanModeratorContainer(final String channelId, final String userId) {
        this.data = new ReqMakeModerator(channelId, userId);
    }

}
