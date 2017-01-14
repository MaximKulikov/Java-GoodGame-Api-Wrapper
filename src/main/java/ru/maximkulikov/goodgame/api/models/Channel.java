package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 03.01.2017.
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

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public String getGgPlayerSrc() {
        return ggPlayerSrc;
    }

    public void setGgPlayerSrc(String ggPlayerSrc) {
        this.ggPlayerSrc = ggPlayerSrc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMaxViewers() {
        return maxViewers;
    }

    public void setMaxViewers(String maxViewers) {
        this.maxViewers = maxViewers;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", premium='" + premium + '\'' +
                ", title='" + title + '\'' +
                ", maxViewers='" + maxViewers + '\'' +
                ", playerType='" + playerType + '\'' +
                ", ggPlayerSrc='" + ggPlayerSrc + '\'' +
                ", embed='" + embed + '\'' +
                ", img='" + img + '\'' +
                ", thumb='" + thumb + '\'' +
                ", description='" + description + '\'' +
                ", adult=" + adult +
                ", games=" + games +
                ", url='" + url + '\'' +
                '}';
    }
}
