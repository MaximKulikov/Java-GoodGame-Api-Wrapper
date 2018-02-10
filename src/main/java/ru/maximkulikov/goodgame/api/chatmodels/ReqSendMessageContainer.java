package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqSendMessageContainer implements ReqChatObject {

    private String type = "send_message";

    private ReqSendMessage data;

    /**
     * @param channelId channel_id
     * @param text      text
     * @param hideIcon  hideIcon
     * @param mobile    mobile
     */
    public ReqSendMessageContainer(final String channelId, final String text, final boolean hideIcon,
                                   final boolean mobile) {
        this.data = new ReqSendMessage(channelId, text, hideIcon, mobile);
    }

    /**
     * @param channelId channel_id
     * @param text      text
     */
    public ReqSendMessageContainer(final String channelId, final String text) {
        this.data = new ReqSendMessage(channelId, text);
    }

}
