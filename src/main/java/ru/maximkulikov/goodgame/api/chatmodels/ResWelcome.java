package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 12.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResWelcome implements ResChatObject {

    private String protocolVersion;

    private String serverIdent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResWelcome that = (ResWelcome) o;

        return new EqualsBuilder()
                .append(protocolVersion, that.protocolVersion)
                .append(serverIdent, that.serverIdent)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(protocolVersion)
                .append(serverIdent)
                .toHashCode();
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    public final void setProtocolVersion(final String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public final String getServerIdent() {
        return this.serverIdent;
    }

    public final void setServerIdent(final String serverIdent) {
        this.serverIdent = serverIdent;
    }

    @Override
    public final String toString() {
        return "ResWelcome{" +
                "protocolVersion='" + this.protocolVersion + '\'' +
                ", serverIdent='" + this.serverIdent + '\'' +
                '}';
    }
}
