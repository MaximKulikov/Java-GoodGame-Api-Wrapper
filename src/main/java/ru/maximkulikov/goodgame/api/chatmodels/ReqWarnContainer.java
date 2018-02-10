package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqWarnContainer implements ReqChatObject {

    private String type = "warn";

    private ReqWarn data;

    /**
     * @param channelId channel_id
     * @param userId    user_id
     * @param reason    reason
     */
    public ReqWarnContainer(final String channelId, final String userId, final String reason) {
        this.data = new ReqWarn(channelId, userId, reason);
    }

}
