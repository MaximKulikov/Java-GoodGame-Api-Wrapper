package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResMotd {
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("moder_id")
    private Long moderId;
    @JsonProperty("moder_name")
    private String moderName;
    @JsonProperty("moder_group")
    private Long moderGroup;
    private String text;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Long getModerGroup() {
        return moderGroup;
    }

    public void setModerGroup(Long moderGroup) {
        this.moderGroup = moderGroup;
    }

    public Long getModerId() {
        return moderId;
    }

    public void setModerId(Long moderId) {
        this.moderId = moderId;
    }

    public String getModerName() {
        return moderName;
    }

    public void setModerName(String moderName) {
        this.moderName = moderName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ResMotd{" +
                "channelId='" + channelId + '\'' +
                ", moderId=" + moderId +
                ", moderName='" + moderName + '\'' +
                ", moderGroup=" + moderGroup +
                ", text='" + text + '\'' +
                '}';
    }
}
