package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamContainer {

    private Stream stream;

    public final Stream getStream() {
        return stream;
    }

    public final void setStream(final Stream stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "StreamContainer{" +
                "stream=" + stream +
                '}';
    }
}
