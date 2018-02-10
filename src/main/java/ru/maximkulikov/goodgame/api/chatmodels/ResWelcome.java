package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 12.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResWelcome implements ResChatObject {

    private String protocolVersion;

    private String serverIdent;

}
