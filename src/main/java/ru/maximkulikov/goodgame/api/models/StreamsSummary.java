package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamsSummary {

    private int channels;

    private int viewers;

    public final int getChannels() {
        return channels;
    }

    public final void setChannels(final int channels) {
        this.channels = channels;
    }

    public final int getViewers() {
        return viewers;
    }

    public final void setViewers(final int viewers) {
        this.viewers = viewers;
    }

    @Override
    public int hashCode() {
        int result = channels;
        result = 31 * result + viewers;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StreamsSummary that = (StreamsSummary) o;

        if (channels != that.channels) return false;
        return viewers == that.viewers;
    }

    @Override
    public final String toString() {
        return "StreamsSummary{" +
                "channels=" + channels +
                ", viewers=" + viewers +
                '}';
    }
}
