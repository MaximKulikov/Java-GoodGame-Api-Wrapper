package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 14.01.2017
 */
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

    public final ReqGetPoll getData() {
        return this.data;
    }

    public final void setData(final ReqGetPoll data) {
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
        return "ReqRefreshPremiumContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
