package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResWarn implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    /**
     * id пользователя, кому вынесено предупреждение
     */
    @JsonProperty("user_id")
    private String userId;

    /**
     * ник забаненого пользователя
     */
    @JsonProperty("user_name")
    private String userName;

    /**
     * id пользователя, вынесшего предупреждение
     */
    @JsonProperty("moder_id")
    private String moderId;

    /**
     * ник пользователя, вынесшего бан
     */
    @JsonProperty("moder_name")
    private String moderName;

    /**
     * определяет каким цветом выводить сообщения
     */
    @JsonProperty("moder_group")
    private Long moderGroup;

    private String reason;

}
