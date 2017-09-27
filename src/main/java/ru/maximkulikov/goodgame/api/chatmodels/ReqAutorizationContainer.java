package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqAutorizationContainer implements ReqChatObject {

    private String type = "auth";

    private ReaAuthorization data;

    public ReqAutorizationContainer(final int siteId, final int userId, final String token) {
        this.data = new ReaAuthorization(siteId, userId, token);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ReqAutorizationContainer that = (ReqAutorizationContainer) o;

        return new EqualsBuilder()
                .append(type, that.type)
                .append(data, that.data)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(type)
                .append(data)
                .toHashCode();
    }

    public ReqAutorizationContainer(final int siteId, final int userId) {
        this.data = new ReaAuthorization(siteId, userId);
    }

    public final ReaAuthorization getData() {
        return this.data;
    }

    public final void setData(final ReaAuthorization data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqAutorizationContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
