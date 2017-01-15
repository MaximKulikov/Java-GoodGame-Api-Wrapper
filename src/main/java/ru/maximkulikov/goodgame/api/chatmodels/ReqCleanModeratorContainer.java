package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqCleanModeratorContainer implements ReqChatObject {

    private String type = "clean_moderator";

    private ReqMakeModerator data;

    public ReqCleanModeratorContainer(String channelId, String userId) {
        this.data = new ReqMakeModerator(channelId, userId);
    }

    public final ReqMakeModerator getData() {
        return this.data;
    }

    public final void setData(final ReqMakeModerator data) {
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
        return "ReqCleanModeratorContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}