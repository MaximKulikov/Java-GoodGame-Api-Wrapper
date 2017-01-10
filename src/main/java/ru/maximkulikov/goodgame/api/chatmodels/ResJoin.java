package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResJoin {
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("channel_name")
    private String channelName;
    @JsonProperty("channel_streamer")
    private ResChannelStreamer channelStreamer;
    private String motd;
    private int slowmod; // задержка в секундах между отправкой сообщений
    private int smiles;
    private int smilePeka;
    @JsonProperty("clients_in_channel")
    private Long clientsInChannel; // всего клиентов в канале, включая гостей
    @JsonProperty("usersInChannel")
    private Long users_in_channel; // всего авторизованных пользователей в канале
    @JsonProperty("user_id")
    private String userId; // для гостей "0"
    private String name; // для гостей ""
    @JsonProperty("access_rights")
    private String accessRights; // по этому полю клиент понимает права пользователя, в этом канале.
    @JsonProperty("room_privacy")
    private int roomPrivacy; // Уровень приватности комнаты
    @JsonProperty("room_role")
    private int roomRole; // Уровоень доступа пользователя
    @JsonProperty("userGroups")
    private List<String> user_groups; //группы в которых состоит пользователь для данного канала
    @JsonProperty("is_banned")
    private Boolean isBanned; // забанен или нет в этом канале
    @JsonProperty("banned_time")
    private Long bannedTime; // до какого времени забанен.
    private String reason; // текстовая строка с причиной бана.
    private List<String> paidsmiles;

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public Long getBannedTime() {
        return bannedTime;
    }

    public void setBannedTime(Long bannedTime) {
        this.bannedTime = bannedTime;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public ResChannelStreamer getChannelStreamer() {
        return channelStreamer;
    }

    public void setChannelStreamer(ResChannelStreamer channelStreamer) {
        this.channelStreamer = channelStreamer;
    }

    public Long getClientsInChannel() {
        return clientsInChannel;
    }

    public void setClientsInChannel(Long clientsInChannel) {
        this.clientsInChannel = clientsInChannel;
    }

    public String getMotd() {
        return motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPaidsmiles() {
        return paidsmiles;
    }

    public void setPaidsmiles(List<String> paidsmiles) {
        this.paidsmiles = paidsmiles;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getRoomPrivacy() {
        return roomPrivacy;
    }

    public void setRoomPrivacy(int roomPrivacy) {
        this.roomPrivacy = roomPrivacy;
    }

    public int getRoomRole() {
        return roomRole;
    }

    public void setRoomRole(int roomRole) {
        this.roomRole = roomRole;
    }

    public int getSlowmod() {
        return slowmod;
    }

    public void setSlowmod(int slowmod) {
        this.slowmod = slowmod;
    }

    public int getSmilePeka() {
        return smilePeka;
    }

    public void setSmilePeka(int smilePeka) {
        this.smilePeka = smilePeka;
    }

    public int getSmiles() {
        return smiles;
    }

    public void setSmiles(int smiles) {
        this.smiles = smiles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getUser_groups() {
        return user_groups;
    }

    public void setUser_groups(List<String> user_groups) {
        this.user_groups = user_groups;
    }

    public Long getUsers_in_channel() {
        return users_in_channel;
    }

    public void setUsers_in_channel(Long users_in_channel) {
        this.users_in_channel = users_in_channel;
    }

    @Override
    public String toString() {
        return "ResJoin{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", channelStreamer=" + channelStreamer +
                ", motd='" + motd + '\'' +
                ", slowmod=" + slowmod +
                ", smiles=" + smiles +
                ", smilePeka=" + smilePeka +
                ", clientsInChannel=" + clientsInChannel +
                ", users_in_channel=" + users_in_channel +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", accessRights='" + accessRights + '\'' +
                ", roomPrivacy=" + roomPrivacy +
                ", roomRole=" + roomRole +
                ", user_groups=" + user_groups +
                ", isBanned=" + isBanned +
                ", bannedTime=" + bannedTime +
                ", reason='" + reason + '\'' +
                ", paidsmiles=" + paidsmiles +
                '}';
    }
}
