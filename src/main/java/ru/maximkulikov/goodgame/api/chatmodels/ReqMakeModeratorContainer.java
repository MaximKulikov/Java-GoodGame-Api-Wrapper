package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqMakeModeratorContainer  implements ReqChatObject {
    private String type = "make_moderator";
    private ReqMakeModerator data;

    public ReqMakeModeratorContainer(String channelId, String userId) {
        this.data = new ReqMakeModerator(channelId, userId);
    }

    public ReqMakeModerator getData() {
        return data;
    }

    public void setData(ReqMakeModerator data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReqMakeModeratorContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}