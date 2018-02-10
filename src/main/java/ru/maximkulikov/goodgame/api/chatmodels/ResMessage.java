package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResMessage implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_rights")
    private Long userRights;

    private Boolean premium;

    private Boolean hideIcon;

    private Boolean mobile;

    private String payments;

    private List<String> paidsmiles;

    @JsonProperty("message_id")
    private String messageId;

    private String timestamp;

    private String color;

    private String text;

}
