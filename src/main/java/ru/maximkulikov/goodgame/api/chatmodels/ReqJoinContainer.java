package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 08.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqJoinContainer implements ReqChatObject {

    private String type = "join";

    private ReqJoin data;

    /**
     * @param channelId channel_id
     */
    public ReqJoinContainer(final String channelId) {
        this.data = new ReqJoin(channelId, false, false);
    }

    /**
     * @param channelId channel_id
     * @param hidden    hidden
     * @param mobile    mobile
     */
    public ReqJoinContainer(final String channelId, final boolean hidden, final boolean mobile) {
        this.data = new ReqJoin(channelId, hidden, mobile);
    }

    public final ReqJoin getData() {
        return this.data;
    }

    public final void setData(final ReqJoin data) {
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
        return "ReqJoinContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
