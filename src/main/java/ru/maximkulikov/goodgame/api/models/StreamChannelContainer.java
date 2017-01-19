package ru.maximkulikov.goodgame.api.models;

import java.util.List;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 18.01.2017.
 */
public class StreamChannelContainer {

    private List<ChannelContainer> streams;

    public final List<ChannelContainer> getStreams() {
        return this.streams;
    }

    public final void setStreams(final List<ChannelContainer> streams) {
        this.streams = streams;
    }

    @Override
    public final String toString() {
        return "StreamChannelContainer{" +
                "streams=" + this.streams +
                '}';
    }
}
