package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 08.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelsListContainer implements ReqChatObject {

    private String type = "get_channels_list";

    private ReqChannelsList data;

    /**
     * @param start начальная позиция
     * @param count количество
     */
    public ReqChannelsListContainer(final int start, final int count) {
        this.data = new ReqChannelsList(start, count);
    }

}
