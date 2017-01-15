package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqGetUserInfoContainer implements ReqChatObject {

    private String type = "get_user_info";

    private ReqGetUserInfo data;

    public ReqGetUserInfoContainer(final String userId) {
        this.data = new ReqGetUserInfo(userId);
    }

    public final ReqGetUserInfo getData() {
        return this.data;
    }

    public final void setData(final ReqGetUserInfo data) {
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
        return "ReqGetUserInfoContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
