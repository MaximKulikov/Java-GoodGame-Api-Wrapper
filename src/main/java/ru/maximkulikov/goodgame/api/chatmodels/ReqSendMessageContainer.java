package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
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

    public final ReqSendMessage getData() {
        return this.data;
    }

    public final void setData(final ReqSendMessage data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqSendMessageContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
