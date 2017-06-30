package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    private InfoToken token;

    private InfoUser user;

    private InfoChannel channel;

    /**
     * @return channel
     */
    public final InfoChannel getChannel() {
        return this.channel;
    }

    public final void setChannel(final InfoChannel channel) {
        this.channel = channel;
    }

    /**
     * @return token
     */
    public final InfoToken getToken() {
        return this.token;
    }

    public final void setToken(final InfoToken token) {
        this.token = token;
    }

    /**
     * @return user
     */
    public final InfoUser getUser() {
        return this.user;
    }

    public final void setUser(final InfoUser user) {
        this.user = user;
    }

    @Override
    public final String toString() {
        return "Info{" +
                "channel=" + this.channel +
                ", user=" + this.user +
                ", token=" + this.token +
                '}';
    }
}
