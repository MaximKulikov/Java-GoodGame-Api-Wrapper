package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 14.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResSettings implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private String name;

    private String value;

    @JsonProperty("moder_id")
    private String moderId;

    @JsonProperty("moder_name")
    private String moderName;

    @JsonProperty("moder_rights")
    private Long moderRights;

    @JsonProperty("moder_groups")
    private List<String> moderGroups;

    private Long silent;

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

    public final String getName() {
        return this.name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final Long getSilent() {
        return this.silent;
    }

    public final void setSilent(final Long silent) {
        this.silent = silent;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(final String value) {
        this.value = value;
    }

    @Override
    public final String toString() {
        return "ResSettings{" +
                "channelId='" + this.channelId + '\'' +
                ", name='" + this.name + '\'' +
                ", value='" + this.value + '\'' +
                ", moderId='" + this.moderId + '\'' +
                ", moderName='" + this.moderName + '\'' +
                ", moderRights=" + this.moderRights +
                ", moderGroups=" + this.moderGroups +
                ", silent=" + this.silent +
                '}';
    }
}
