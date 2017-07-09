package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqIgnoreListContainer implements ReqChatObject {

    private String type = "get_ignore_list";

    private Empty data = new Empty();

    public final Empty getData() {
        return this.data;
    }

    /**
     *
     */
    public ReqIgnoreListContainer() {
    }

    public final void setData(final Empty data) {
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
        return "ReqIgnoreListContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
