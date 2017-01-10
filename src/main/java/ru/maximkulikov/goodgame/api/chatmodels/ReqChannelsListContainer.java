package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelsListContainer  implements ChatObject {
    private String type = "get_channels_list";
    private ReqChannelsList data;

    public ReqChannelsListContainer(int start, int count) {
        this.data = new ReqChannelsList(start, count);
    }
    public ReqChannelsListContainer() {
        this.data = new ReqChannelsList(0, 50);
    }

    @Override
    public String toString() {
        return "ReqChannelsListContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ReqChannelsList getData() {
        return data;
    }

    public void setData(ReqChannelsList data) {
        this.data = data;
    }
}
