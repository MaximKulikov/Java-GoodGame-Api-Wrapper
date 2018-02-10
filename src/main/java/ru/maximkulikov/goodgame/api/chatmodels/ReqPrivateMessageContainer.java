package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqPrivateMessageContainer implements ReqChatObject {

    private String type = "send_private_message";

    private ReqPrivateMessage data;

    /**
     * @param channelId channel_id
     * @param userId    user_id
     * @param text      text
     */
    public ReqPrivateMessageContainer(final String channelId, final String userId, final String text) {
        this.data = new ReqPrivateMessage(channelId, userId, text);
    }

}
