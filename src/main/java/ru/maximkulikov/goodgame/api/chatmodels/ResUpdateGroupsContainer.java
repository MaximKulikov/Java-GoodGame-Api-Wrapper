package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 14.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdateGroupsContainer {

    private String type;

    private ResUpdateGroups data;

    public final ResUpdateGroups getData() {
        return this.data;
    }

    public final void setData(final ResUpdateGroups data) {
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
        return "ResUpdateGroupsContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
