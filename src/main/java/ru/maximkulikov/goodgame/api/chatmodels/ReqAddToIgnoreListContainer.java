package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqAddToIgnoreListContainer implements ReqChatObject {

    private String type = "add_to_ignore_list";

    private ReqChangeIgnoreList data;

    /**
     * @param userId User Id
     */
    public ReqAddToIgnoreListContainer(final String userId) {
        this.data = new ReqChangeIgnoreList(userId);
    }

    /**
     * @return data
     */
    public final ReqChangeIgnoreList getData() {
        return this.data;
    }

    public final void setData(final ReqChangeIgnoreList data) {
        this.data = data;
    }

    /**
     * @return add_to_ignore_list
     */
    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqAddToIgnoreListContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
