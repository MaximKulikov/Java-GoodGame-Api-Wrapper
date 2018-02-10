package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 09.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqAddToIgnoreListContainer implements ReqChatObject {

    private String type = "add_to_ignore_list";

    private ReqChangeIgnoreList data;

}
