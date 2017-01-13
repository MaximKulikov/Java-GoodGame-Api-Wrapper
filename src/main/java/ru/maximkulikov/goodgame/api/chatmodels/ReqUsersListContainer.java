package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqUsersListContainer implements ReqChatObject {
    private String type = "get_users_list";
    private ReqUsersList data;

    public ReqUsersListContainer(String channelId) {
        this.data = new ReqUsersList(channelId);
    }

    @Override
    public String toString() {
        return "ReqUsersListContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public ReqUsersList getData() {
        return data;
    }

    public void setData(ReqUsersList data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
