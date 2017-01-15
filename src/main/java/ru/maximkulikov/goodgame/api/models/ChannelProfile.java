package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelProfile {

    @JsonProperty("stream_id")
    private String streamId;

    private String key;

    private String premium;

    private String title;

    private String status;

    private String viewers;

    @JsonProperty("max_viewers")
    private Boolean maxViewers;

    @JsonProperty("usersinchat")
    private String usersInChat;

    private String embed;

    private String img;

    private String thumb;

    private String description;

    private String adult;

    private String games;

    private String url;

    public final String getAdult() {
        return this.adult;
    }

    public final void setAdult(final String adult) {
        this.adult = adult;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(final String description) {
        this.description = description;
    }

    public final String getEmbed() {
        return this.embed;
    }

    public final void setEmbed(final String embed) {
        this.embed = embed;
    }

    public final String getGames() {
        return this.games;
    }

    public final void setGames(final String games) {
        this.games = games;
    }

    public final String getImg() {
        return this.img;
    }

    public final void setImg(final String img) {
        this.img = img;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(final String key) {
        this.key = key;
    }

    public final Boolean getMaxViewers() {
        return this.maxViewers;
    }

    public final void setMaxViewers(final Boolean maxViewers) {
        this.maxViewers = maxViewers;
    }

    public final String getPremium() {
        return this.premium;
    }

    public final void setPremium(final String premium) {
        this.premium = premium;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

    public final String getStreamId() {
        return this.streamId;
    }

    public final void setStreamId(final String streamId) {
        this.streamId = streamId;
    }

    public final String getThumb() {
        return this.thumb;
    }

    public final void setThumb(final String thumb) {
        this.thumb = thumb;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(final String url) {
        this.url = url;
    }

    public final String getUsersInChat() {
        return this.usersInChat;
    }

    public final void setUsersInChat(final String usersInChat) {
        this.usersInChat = usersInChat;
    }

    public final String getViewers() {
        return this.viewers;
    }

    public final void setViewers(final String viewers) {
        this.viewers = viewers;
    }

    @Override
    public final String toString() {
        return "ChannelProfile{" +
                "streamId='" + this.streamId + '\'' +
                ", key='" + this.key + '\'' +
                ", premium='" + this.premium + '\'' +
                ", title='" + this.title + '\'' +
                ", status='" + this.status + '\'' +
                ", viewers='" + this.viewers + '\'' +
                ", maxViewers=" + this.maxViewers +
                ", usersInChat='" + this.usersInChat + '\'' +
                ", embed='" + this.embed + '\'' +
                ", img='" + this.img + '\'' +
                ", thumb='" + this.thumb + '\'' +
                ", description='" + this.description + '\'' +
                ", adult='" + this.adult + '\'' +
                ", games='" + this.games + '\'' +
                ", url='" + this.url + '\'' +
                '}';
    }
}
