package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResJoin implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("channel_name")
    private String channelName;

    @JsonProperty("channel_streamer")
    private ResChannelStreamer channelStreamer;

    private String motd;

    private int slowmod;

    private int smiles;

    private int smilePeka;

    @JsonProperty("clients_in_channel")
    private Long clientsInChannel;

    @JsonProperty("users_in_channel")
    private Long usersInChannel;

    @JsonProperty("user_id")
    private String userId;

    private String name;

    @JsonProperty("access_rights")
    private String accessRights;

    @JsonProperty("room_privacy")
    private int roomPrivacy;

    @JsonProperty("room_role")
    private int roomRole;

    @JsonProperty("user_groups")
    private List<String> userGroups;

    @JsonProperty("is_banned")
    private Boolean isBanned;

    @JsonProperty("banned_time")
    private Long bannedTime;

    private String reason;

    private List<String> paidsmiles;

    public final String getAccessRights() {
        return this.accessRights;
    }

    public final void setAccessRights(final String accessRights) {
        this.accessRights = accessRights;
    }

    public final Boolean getBanned() {
        return this.isBanned;
    }

    public final void setBanned(final Boolean banned) {
        this.isBanned = banned;
    }

    public final Long getBannedTime() {
        return this.bannedTime;
    }

    public final void setBannedTime(final Long bannedTime) {
        this.bannedTime = bannedTime;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final void setChannelName(final String channelName) {
        this.channelName = channelName;
    }

    public final ResChannelStreamer getChannelStreamer() {
        return this.channelStreamer;
    }

    public final void setChannelStreamer(final ResChannelStreamer channelStreamer) {
        this.channelStreamer = channelStreamer;
    }

    public final Long getClientsInChannel() {
        return this.clientsInChannel;
    }

    public final void setClientsInChannel(final Long clientsInChannel) {
        this.clientsInChannel = clientsInChannel;
    }

    public final String getMotd() {
        return this.motd;
    }

    public final void setMotd(final String motd) {
        this.motd = motd;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final List<String> getPaidsmiles() {
        return this.paidsmiles;
    }

    public final void setPaidsmiles(final List<String> paidsmiles) {
        this.paidsmiles = paidsmiles;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setReason(final String reason) {
        this.reason = reason;
    }

    public final int getRoomPrivacy() {
        return this.roomPrivacy;
    }

    public final void setRoomPrivacy(final int roomPrivacy) {
        this.roomPrivacy = roomPrivacy;
    }

    public final int getRoomRole() {
        return this.roomRole;
    }

    public final void setRoomRole(final int roomRole) {
        this.roomRole = roomRole;
    }

    public final int getSlowmod() {
        return this.slowmod;
    }

    public final void setSlowmod(final int slowmod) {
        this.slowmod = slowmod;
    }

    public final int getSmilePeka() {
        return this.smilePeka;
    }

    public final void setSmilePeka(final int smilePeka) {
        this.smilePeka = smilePeka;
    }

    public final int getSmiles() {
        return this.smiles;
    }

    public final void setSmiles(final int smiles) {
        this.smiles = smiles;
    }

    public final List<String> getUserGroups() {
        return this.userGroups;
    }

    public final void setUserGroups(final List<String> userGroups) {
        this.userGroups = userGroups;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    public final Long getUsersInChannel() {
        return this.usersInChannel;
    }

    public final void setUsersInChannel(final Long usersInChannel) {
        this.usersInChannel = usersInChannel;
    }

    @Override
    public final String toString() {
        return "ResJoin{" +
                "channelId='" + this.channelId + '\'' +
                ", channelName='" + this.channelName + '\'' +
                ", channelStreamer=" + this.channelStreamer +
                ", motd='" + this.motd + '\'' +
                ", slowmod=" + this.slowmod +
                ", smiles=" + this.smiles +
                ", smilePeka=" + this.smilePeka +
                ", clientsInChannel=" + this.clientsInChannel +
                ", usersInChannel=" + this.usersInChannel +
                ", userId='" + this.userId + '\'' +
                ", name='" + this.name + '\'' +
                ", accessRights='" + this.accessRights + '\'' +
                ", roomPrivacy=" + this.roomPrivacy +
                ", roomRole=" + this.roomRole +
                ", userGroups=" + this.userGroups +
                ", isBanned=" + this.isBanned +
                ", bannedTime=" + this.bannedTime +
                ", reason='" + this.reason + '\'' +
                ", paidsmiles=" + this.paidsmiles +
                '}';
    }
}
