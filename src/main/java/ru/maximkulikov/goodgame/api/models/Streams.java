package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Streams {

    private List<Stream> streams;

    @JsonProperty("_total")
    private int total;

    public final List<Stream> getStreams() {
        return streams;
    }

    public final void setStreams(final List<Stream> streams) {
        this.streams = streams;
    }

    public final int getTotal() {
        return total;
    }

    public final void setTotal(final int total) {
        this.total = total;
    }

    @Override
    public final String toString() {
        return "Streams{" +
                "total=" + total +
                ", streams=" + streams +
                '}';
    }
}
