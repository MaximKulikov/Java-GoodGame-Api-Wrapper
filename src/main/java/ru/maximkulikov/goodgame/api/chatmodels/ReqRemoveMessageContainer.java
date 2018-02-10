package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRemoveMessageContainer implements ReqChatObject {

    private String type = "remove_message";

    private ReqRemoveMessage data;

    /**
     * @param channelId channel_id
     * @param messageId message_id
     */
    public ReqRemoveMessageContainer(final String channelId, final String messageId) {
        this.data = new ReqRemoveMessage(channelId, messageId);
    }
}
