package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChangeIgnoreList {

    @JsonProperty("user_id")
    private String userId;

    /**
     * @param userId user_id
     */
    public ReqChangeIgnoreList(final String userId) {
        this.userId = userId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public final String toString() {
        return "ReqAddToIgnoreList{" +
                "userId='" + this.userId + '\'' +
                '}';
    }
}
