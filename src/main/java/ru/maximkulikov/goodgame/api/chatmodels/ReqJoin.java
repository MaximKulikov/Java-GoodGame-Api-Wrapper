package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Maxim Kulkov
 * @since 08.01.2017
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqJoin {

    @JsonProperty("channel_id")
    private String channelId;

    private boolean hidden;

    private boolean mobile;

}
