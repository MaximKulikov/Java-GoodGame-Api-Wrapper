package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqDelFromIgnoreListContainer implements ReqChatObject {

    private String type = "del_from_ignore_list";

    private ReqChangeIgnoreList data;

    /**
     * @param userId user_id
     */
    public ReqDelFromIgnoreListContainer(final String userId) {
        this.data = new ReqChangeIgnoreList(userId);
    }

    public final ReqChangeIgnoreList getData() {
        return this.data;
    }

    public final void setData(final ReqChangeIgnoreList data) {
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
        return "ReqDelFromIgnoreListContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
