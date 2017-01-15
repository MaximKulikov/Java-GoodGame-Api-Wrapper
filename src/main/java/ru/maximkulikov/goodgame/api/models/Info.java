package ru.maximkulikov.goodgame.api.models;

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

    public final InfoChannel getChannel() {
        return channel;
    }

    public final void setChannel(final InfoChannel channel) {
        this.channel = channel;
    }

    public final InfoToken getToken() {
        return token;
    }

    public final void setToken(final InfoToken token) {
        this.token = token;
    }

    public final InfoUser getUser() {
        return user;
    }

    public final void setUser(final InfoUser user) {
        this.user = user;
    }

    @Override
    public final String toString() {
        return "Info{" +
                "channel=" + channel +
                ", user=" + user +
                ", token=" + token +
                '}';
    }
}
