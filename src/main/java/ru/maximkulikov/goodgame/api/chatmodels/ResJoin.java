package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@Data
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
    private Integer clientsInChannel;

    @JsonProperty("users_in_channel")
    private Integer usersInChannel;

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

}
