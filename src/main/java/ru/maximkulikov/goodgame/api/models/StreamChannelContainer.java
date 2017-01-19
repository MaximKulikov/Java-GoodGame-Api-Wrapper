package ru.maximkulikov.goodgame.api.models;

import java.util.List;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 18.01.2017.
 */
public class StreamChannelContainer {

    private List<ChannelContainer> streams;

    public List<ChannelContainer> getStreams() {
        return streams;
    }

    public void setStreams(List<ChannelContainer> streams) {
        this.streams = streams;
    }

    @Override
    public String toString() {
        return "StreamChannelContainer{" +
                "streams=" + streams +
                '}';
    }
}
