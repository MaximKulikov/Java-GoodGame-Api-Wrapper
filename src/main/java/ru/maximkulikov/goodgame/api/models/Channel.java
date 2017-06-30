package ru.maximkulikov.goodgame.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {

    private Long id;

    private String key;

    private String premium;

    private String title;

    @JsonProperty("max_viewers")
    private String maxViewers;

    @JsonProperty("player_type")
    private String playerType;

    @JsonProperty("gg_player_src")
    private String ggPlayerSrc;

    private String embed;

    private String img;

    private String thumb;

    private String description;

    private Boolean adult;

    private List<Game> games;

    private String url;

    /**
     * @return adult
     */
    public final Boolean getAdult() {
        return this.adult;
    }

    public final void setAdult(final Boolean adult) {
        this.adult = adult;
    }

    /**
     * @return description
     */
    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return embed
     */
    public final String getEmbed() {
        return this.embed;
    }

    public final void setEmbed(final String embed) {
        this.embed = embed;
    }

    /**
     * @return games
     */
    public final List<Game> getGames() {
        return this.games;
    }

    public final void setGames(final List<Game> games) {
        this.games = games;
    }

    /**
     * @return gg_player_src
     */
    public final String getGgPlayerSrc() {
        return this.ggPlayerSrc;
    }

    public final void setGgPlayerSrc(final String ggPlayerSrc) {
        this.ggPlayerSrc = ggPlayerSrc;
    }

    /**
     * @return id
     */
    public final Long getId() {
        return this.id;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return img
     */
    public final String getImg() {
        return this.img;
    }

    public final void setImg(final String img) {
        this.img = img;
    }

    /**
     * @return key
     */
    public final String getKey() {
        return this.key;
    }

    public final void setKey(final String key) {
        this.key = key;
    }

    /**
     * @return max_viewers
     */
    public final String getMaxViewers() {
        return this.maxViewers;
    }

    public final void setMaxViewers(final String maxViewers) {
        this.maxViewers = maxViewers;
    }

    /**
     * @return player_type
     */
    public final String getPlayerType() {
        return this.playerType;
    }

    public final void setPlayerType(final String playerType) {
        this.playerType = playerType;
    }

    /**
     * @return premium
     */
    public final String getPremium() {
        return this.premium;
    }

    public final void setPremium(final String premium) {
        this.premium = premium;
    }

    /**
     * @return thumb
     */
    public final String getThumb() {
        return this.thumb;
    }

    public final void setThumb(final String thumb) {
        this.thumb = thumb;
    }

    /**
     * @return title
     */
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return url
     */
    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(final String url) {
        this.url = url;
    }

    @Override
    public final String toString() {
        return "Channel{" +
                "id=" + this.id +
                ", key='" + this.key + '\'' +
                ", premium='" + this.premium + '\'' +
                ", title='" + this.title + '\'' +
                ", maxViewers='" + this.maxViewers + '\'' +
                ", playerType='" + this.playerType + '\'' +
                ", ggPlayerSrc='" + this.ggPlayerSrc + '\'' +
                ", embed='" + this.embed + '\'' +
                ", img='" + this.img + '\'' +
                ", thumb='" + this.thumb + '\'' +
                ", description='" + this.description + '\'' +
                ", adult=" + this.adult +
                ", games=" + this.games +
                ", url='" + this.url + '\'' +
                '}';
    }
}
