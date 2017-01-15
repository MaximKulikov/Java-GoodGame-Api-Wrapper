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

    public final String getProtocolVersion() {
        return protocolVersion;
    }

    public final void setProtocolVersion(final String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public final String getServerIdent() {
        return serverIdent;
    }

    public final void setServerIdent(final String serverIdent) {
        this.serverIdent = serverIdent;
    }

    @Override
    public final String toString() {
        return "ResWelcome{" +
                "protocolVersion='" + protocolVersion + '\'' +
                ", serverIdent='" + serverIdent + '\'' +
                '}';
    }
}
