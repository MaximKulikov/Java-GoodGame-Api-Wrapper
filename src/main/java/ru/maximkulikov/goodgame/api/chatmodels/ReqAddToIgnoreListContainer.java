package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqAddToIgnoreListContainer implements ReqChatObject {

    private String type = "add_to_ignore_list";

    private ReqChangeIgnoreList data;

    public ReqAddToIgnoreListContainer(String userId) {
        this.data = new ReqChangeIgnoreList(userId);
    }

    public final ReqChangeIgnoreList getData() {
        return data;
    }

    public final void setData(final ReqChangeIgnoreList data) {
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
        return "ReqAddToIgnoreListContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
