package ru.maximkulikov.goodgame.api.models;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stream {

    @JsonProperty("_id")
    private long id;

    private String game;

    private int viewers;

    private Date createdAt;

    private int videoHeight;

    private double averageFps;

    private StreamPreview preview;

    private ChannelContainer channel;

    public Stream(final long id, final String game, final int viewers, final Date createdAt, final int videoHeight,
                  final double averageFps, final StreamPreview preview, final ChannelContainer channel) {
        this.id = id;
        this.game = game;
        this.viewers = viewers;
        this.createdAt = createdAt;
        this.videoHeight = videoHeight;
        this.averageFps = averageFps;
        this.preview = preview;
        this.channel = channel;
    }

    public final double getAverageFps() {
        return this.averageFps;
    }

    public final void setAverageFps(final double averageFps) {
        this.averageFps = averageFps;
    }

    public final ChannelContainer getChannel() {
        return this.channel;
    }

    public final void setChannel(final ChannelContainer channel) {
        this.channel = channel;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public final String getGame() {
        return this.game;
    }

    public final void setGame(final String game) {
        this.game = game;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(final long id) {
        this.id = id;
    }

    public final StreamPreview getPreview() {
        return this.preview;
    }

    public final void setPreview(final StreamPreview preview) {
        this.preview = preview;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final void setVideoHeight(final int videoHeight) {
        this.videoHeight = videoHeight;
    }

    public final int getViewers() {
        return this.viewers;
    }

    public final void setViewers(final int viewers) {
        this.viewers = viewers;
    }

    @Override
    public final int hashCode() {
        return (int) (this.id ^ (this.id >>> 32));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Stream stream = (Stream) o;

        return this.id == stream.id;
    }

    @Override
    public final String toString() {
        return "Stream{" +
                "id=" + this.id +
                ", game='" + this.game + '\'' +
                ", viewers=" + this.viewers +
                ", createdAt=" + this.createdAt +
                ", videoHeight=" + this.videoHeight +
                ", averageFps=" + this.averageFps +
                ", preview=" + this.preview +
                ", channel=" + this.channel +
                '}';
    }

    public final boolean isOnline() {
        return this.id != 0;
    }
}
