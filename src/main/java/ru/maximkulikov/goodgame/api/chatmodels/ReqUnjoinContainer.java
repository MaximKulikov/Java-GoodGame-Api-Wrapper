package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqUnjoinContainer implements ReqChatObject {

    private String type = "unjoin";

    private ReqUnjoin data;

    public ReqUnjoinContainer(String channelId) {
        this.data = new ReqUnjoin(channelId);
    }

    public final ReqUnjoin getData() {
        return this.data;
    }

    public final void setData(final ReqUnjoin data) {
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
        return "ReqUnjoinContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
