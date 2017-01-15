package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelsList {

    private int start;

    private int count;

    public ReqChannelsList(int start, int count) {
        this.start = start;
        this.count = count;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(final int count) {
        this.count = count;
    }

    public final int getStart() {
        return this.start;
    }

    public final void setStart(final int start) {
        this.start = start;
    }

    @Override
    public final String toString() {
        return "ReqChannelsList{" +
                "start=" + this.start +
                ", count=" + this.count +
                '}';
    }
}
