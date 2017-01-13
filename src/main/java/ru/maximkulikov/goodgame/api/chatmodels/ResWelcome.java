package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 12.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResWelcome implements ResChatObject {
    private String protocolVersion;
    private String serverIdent;

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getServerIdent() {
        return serverIdent;
    }

    public void setServerIdent(String serverIdent) {
        this.serverIdent = serverIdent;
    }

    @Override
    public String toString() {
        return "ResWelcome{" +
                "protocolVersion='" + protocolVersion + '\'' +
                ", serverIdent='" + serverIdent + '\'' +
                '}';
    }
}
