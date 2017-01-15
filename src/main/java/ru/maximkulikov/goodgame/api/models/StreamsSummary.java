package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamsSummary {

    private int channels;

    private int viewers;

    public final int getChannels() {
        return this.channels;
    }

    public final void setChannels(final int channels) {
        this.channels = channels;
    }

    public final int getViewers() {
        return this.viewers;
    }

    public final void setViewers(final int viewers) {
        this.viewers = viewers;
    }

    @Override
    public final int hashCode() {
        int result = this.channels;
        result = 31 * result + this.viewers;
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StreamsSummary that = (StreamsSummary) o;

        if (this.channels != that.channels) {
            return false;
        }
        return this.viewers == that.viewers;
    }

    @Override
    public final String toString() {
        return "StreamsSummary{" +
                "channels=" + this.channels +
                ", viewers=" + this.viewers +
                '}';
    }
}
