package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelCounters implements ReqChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    /**
     *
     * @param channelId channel_id
     */
    public ReqChannelCounters(final String channelId) {
        this.channelId = channelId;
    }

}
