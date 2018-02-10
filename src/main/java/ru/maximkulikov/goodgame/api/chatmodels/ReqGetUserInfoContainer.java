package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqGetUserInfoContainer implements ReqChatObject {

    private String type = "get_user_info";

    private ReqGetUserInfo data;

    /**
     * @param userId user_id
     */
    public ReqGetUserInfoContainer(final String userId) {
        this.data = new ReqGetUserInfo(userId);
    }

}
