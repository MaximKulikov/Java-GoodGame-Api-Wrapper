package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * @author Maxim Kulikov
 * @since 14.01.2017
 */
@Data
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

}

