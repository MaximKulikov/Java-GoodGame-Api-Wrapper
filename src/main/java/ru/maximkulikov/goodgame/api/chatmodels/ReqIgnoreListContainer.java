package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqIgnoreListContainer implements ReqChatObject {

    private String type = "get_ignore_list";

    private Object data = new Object();

    public ReqIgnoreListContainer() {
    }

    public final Object getData() {
        return data;
    }

    public final void setData(final Object data) {
        this.data = data;
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqIgnoreListContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
