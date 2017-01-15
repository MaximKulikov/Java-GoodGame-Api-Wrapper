package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelsList implements ResChatObject {

    private List<ChatChannel> channels;

    public final List<ChatChannel> getChannels() {
        return this.channels;
    }

    public final void setChannels(final List<ChatChannel> channels) {
        this.channels = channels;
    }

    @Override
    public final String toString() {
        return "ResChannelsList{" +
                "channels=" + this.channels +
                '}';
    }
}
