package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@Data
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

}
