package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResMotd implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("moder_id")
    private Long moderId;

    @JsonProperty("moder_name")
    private String moderName;

    @JsonProperty("moder_group")
    private Long moderGroup;

    private String text;

    public final String getChannelId() {
        return channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final Long getModerGroup() {
        return moderGroup;
    }

    public final void setModerGroup(final Long moderGroup) {
        this.moderGroup = moderGroup;
    }

    public final Long getModerId() {
        return moderId;
    }

    public final void setModerId(final Long moderId) {
        this.moderId = moderId;
    }

    public final String getModerName() {
        return moderName;
    }

    public final void setModerName(final String moderName) {
        this.moderName = moderName;
    }

    public final String getText() {
        return text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    @Override
    public final String toString() {
        return "ResMotd{" +
                "channelId='" + channelId + '\'' +
                ", moderId=" + moderId +
                ", moderName='" + moderName + '\'' +
                ", moderGroup=" + moderGroup +
                ", text='" + text + '\'' +
                '}';
    }
}
