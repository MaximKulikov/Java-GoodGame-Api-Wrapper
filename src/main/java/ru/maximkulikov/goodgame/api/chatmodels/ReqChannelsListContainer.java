package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 08.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelsListContainer implements ReqChatObject {

    private String type = "get_channels_list";

    private ReqChannelsList data;

    /**
     *
     * @param start начальная позиция
     * @param count количество
     */
    public ReqChannelsListContainer(final int start, final int count) {
        this.data = new ReqChannelsList(start, count);
    }

    /**
     *  Отображение первых 50 элементов
     */
    public ReqChannelsListContainer() {
        this.data = new ReqChannelsList(0, 50);
    }

    public final ReqChannelsList getData() {
        return this.data;
    }

    public final void setData(final ReqChannelsList data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqChannelsListContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
