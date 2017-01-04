package com.mb3364.twitch.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

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
    private String max_viewers;
    private String player_type;
    private String gg_player_src;
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

    public String getGg_player_src() {
        return gg_player_src;
    }

    public void setGg_player_src(String gg_player_src) {
        this.gg_player_src = gg_player_src;
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

    public String getMax_viewers() {
        return max_viewers;
    }

    public void setMax_viewers(String max_viewers) {
        this.max_viewers = max_viewers;
    }

    public String getPlayer_type() {
        return player_type;
    }

    public void setPlayer_type(String player_type) {
        this.player_type = player_type;
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
                ", max_viewers='" + max_viewers + '\'' +
                ", player_type='" + player_type + '\'' +
                ", gg_player_src='" + gg_player_src + '\'' +
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
