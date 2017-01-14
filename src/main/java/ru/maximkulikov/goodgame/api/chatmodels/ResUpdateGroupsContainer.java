package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 14.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResUpdateGroupsContainer {

    private String type;

    private ResUpdateGroups data;

    public final ResUpdateGroups getData() {
        return this.data;
    }

    public void setData(final ResUpdateGroups data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ResUpdateGroupsContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}