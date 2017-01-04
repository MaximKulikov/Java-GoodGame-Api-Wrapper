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

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
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

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
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

    public Boolean getMaxViewers() {
        return maxViewers;
    }

    public void setMaxViewers(Boolean maxViewers) {
        this.maxViewers = maxViewers;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
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

    public String getUsersInChat() {
        return usersInChat;
    }

    public void setUsersInChat(String usersInChat) {
        this.usersInChat = usersInChat;
    }

    public String getViewers() {
        return viewers;
    }

    public void setViewers(String viewers) {
        this.viewers = viewers;
    }

    @Override
    public String toString() {
        return "ChannelProfile{" +
                "streamId='" + streamId + '\'' +
                ", key='" + key + '\'' +
                ", premium='" + premium + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", viewers='" + viewers + '\'' +
                ", maxViewers=" + maxViewers +
                ", usersInChat='" + usersInChat + '\'' +
                ", embed='" + embed + '\'' +
                ", img='" + img + '\'' +
                ", thumb='" + thumb + '\'' +
                ", description='" + description + '\'' +
                ", adult='" + adult + '\'' +
                ", games='" + games + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
