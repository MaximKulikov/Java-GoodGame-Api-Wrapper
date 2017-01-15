package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 14.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResNewPoll implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("moder_id")
    private String moderId;

    @JsonProperty("moder_name")
    private String moderName;

    @JsonProperty("moder_rights")
    private Long moderRights;

    @JsonProperty("moder_groups")
    private List<String> moderGroups;

    private String title;

    private List<PollAnswer> answers;

    public ResNewPoll() {
    }

    public final List<PollAnswer> getAnswers() {
        return this.answers;
    }

    public final void setAnswers(final List<PollAnswer> answers) {
        this.answers = answers;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final List<String> getModerGroups() {
        return this.moderGroups;
    }

    public final void setModerGroups(final List<String> moderGroups) {
        this.moderGroups = moderGroups;
    }

    public final String getModerId() {
        return this.moderId;
    }

    public final void setModerId(final String moderId) {
        this.moderId = moderId;
    }

    public final String getModerName() {
        return this.moderName;
    }

    public final void setModerName(final String moderName) {
        this.moderName = moderName;
    }

    public final Long getModerRights() {
        return this.moderRights;
    }

    public final void setModerRights(final Long moderRights) {
        this.moderRights = moderRights;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public final String toString() {
        return "ResNewPoll{" +
                "channelId='" + this.channelId + '\'' +
                ", moderId='" + this.moderId + '\'' +
                ", moderName='" + this.moderName + '\'' +
                ", moderRights=" + this.moderRights +
                ", moderGroups=" + this.moderGroups +
                ", title='" + this.title + '\'' +
                ", answers=" + this.answers +
                '}';
    }
}

