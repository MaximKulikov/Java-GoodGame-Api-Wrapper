package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Maxim Kulikov
 * @since 08.01.2017
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor()
@JsonIgnoreProperties(ignoreUnknown = true)
class ReqAuthorization {

    @JsonProperty("site_id")
    private int siteId;

    @JsonProperty("user_id")
    private int userId;

    private String token;

    /**
     * @param siteId site_id
     * @param userId user_id
     */
    ReqAuthorization(final int siteId, final int userId) {
        this.siteId = siteId;
        this.userId = userId;
    }
}
