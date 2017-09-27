package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @since 29.12.2016
 * @author MaximKulikov
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Broadcast {

    @JsonProperty("broadcast_title")
    private String broadcastTitle;

    @JsonProperty("broadcast_start")
    private String broadcastStart;

    @JsonProperty("broadcast_games")
    private String broadcastGames;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Broadcast broadcast = (Broadcast) o;

        return new EqualsBuilder()
                .append(broadcastTitle, broadcast.broadcastTitle)
                .append(broadcastStart, broadcast.broadcastStart)
                .append(broadcastGames, broadcast.broadcastGames)
                .append(broadcastDescription, broadcast.broadcastDescription)
                .append(broadcastLogo, broadcast.broadcastLogo)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(broadcastTitle)
                .append(broadcastStart)
                .append(broadcastGames)
                .append(broadcastDescription)
                .append(broadcastLogo)
                .toHashCode();
    }

    @JsonProperty("broadcast_description")
    private String broadcastDescription;

    @JsonProperty("broadcast_logo")
    private String broadcastLogo;

    public final String getBroadcastDescription() {
        return this.broadcastDescription;
    }

    public final void setBroadcastDescription(final String broadcastDescription) {
        this.broadcastDescription = broadcastDescription;
    }

    public final String getBroadcastGames() {
        return this.broadcastGames;
    }

    public final void setBroadcastGames(final String broadcastGames) {
        this.broadcastGames = broadcastGames;
    }

    public final String getBroadcastLogo() {
        return this.broadcastLogo;
    }

    public final void setBroadcastLogo(final String broadcastLogo) {
        this.broadcastLogo = broadcastLogo;
    }

    public final String getBroadcastStart() {
        return this.broadcastStart;
    }

    public final void setBroadcastStart(final String broadcastStart) {
        this.broadcastStart = broadcastStart;
    }

    public final String getBroadcastTitle() {
        return this.broadcastTitle;
    }

    public final void setBroadcastTitle(final String broadcastTitle) {
        this.broadcastTitle = broadcastTitle;
    }

    @Override
    public final String toString() {
        return "Broadcast{" +
                "broadcastTitle='" + this.broadcastTitle + '\'' +
                ", broadcastStart='" + this.broadcastStart + '\'' +
                ", broadcastGames='" + this.broadcastGames + '\'' +
                ", broadcastDescription='" + this.broadcastDescription + '\'' +
                ", broadcastLogo='" + this.broadcastLogo + '\'' +
                '}';
    }
}
