package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqSendMessage {

    @JsonProperty("channel_id")
    private @NonNull
    String channelId;

    private @NonNull
    String text;

    private boolean hideIcon = false;

    private boolean mobile = false;


}
