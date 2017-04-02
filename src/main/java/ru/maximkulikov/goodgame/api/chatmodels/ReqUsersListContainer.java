package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqUsersListContainer implements ReqChatObject {

    private String type = "get_users_list2";

    private ReqUsersList data;

    public ReqUsersListContainer(final String channelId) {
        this.data = new ReqUsersList(channelId);
    }

    public final ReqUsersList getData() {
        return this.data;
    }

    public final void setData(final ReqUsersList data) {
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
        return "ReqUsersListContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
