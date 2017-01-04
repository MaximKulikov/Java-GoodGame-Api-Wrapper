package com.mb3364.twitch.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
    private InfoToken token;
    private InfoUser user;
    private InfoChannel channel;

    public InfoChannel getChannel() {
        return channel;
    }

    public void setChannel(InfoChannel channel) {
        this.channel = channel;
    }

    public InfoToken getToken() {
        return token;
    }

    public void setToken(InfoToken token) {
        this.token = token;
    }

    public InfoUser getUser() {
        return user;
    }

    public void setUser(InfoUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Info{" +
                "channel=" + channel +
                ", user=" + user +
                ", token=" + token +
                '}';
    }
}
