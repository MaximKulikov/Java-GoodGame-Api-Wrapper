package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqDelFromIgnoreListContainer implements ReqChatObject {
    private String type = "del_from_ignore_list";
    private ReqChangeIgnoreList data;

    public ReqDelFromIgnoreListContainer(String userId) {
        this.data = new ReqChangeIgnoreList(userId);
    }

    public ReqChangeIgnoreList getData() {
        return data;
    }

    public void setData(ReqChangeIgnoreList data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override

    public String toString() {
        return "ReqDelFromIgnoreListContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
