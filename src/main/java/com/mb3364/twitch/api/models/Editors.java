package com.mb3364.twitch.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Editors {

    private List<User_Twitch> users;

    public List<User_Twitch> getUsers() {
        return users;
    }

    public void setUsers(List<User_Twitch> users) {
        this.users = users;
    }
}
