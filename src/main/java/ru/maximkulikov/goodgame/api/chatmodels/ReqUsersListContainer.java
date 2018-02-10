package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqUsersListContainer implements ReqChatObject {

    private String type = "get_users_list2";

    private ReqUsersList data;

    /**
     * @param channelId channel_id
     */
    public ReqUsersListContainer(final String channelId) {
        this.data = new ReqUsersList(channelId);
    }

}
