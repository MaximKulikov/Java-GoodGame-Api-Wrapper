package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResIgnoreList implements ResChatObject {
    private List<ChatUser> users;

    public List<ChatUser> getUsers() {
        return users;
    }

    public void setUsers(List<ChatUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ResIgnoreList{" +
                "users=" + users +
                '}';
    }
}
