package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResModeratorsList implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    private List<ChatUser> users;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final List<ChatUser> getUsers() {
        return this.users;
    }

    public final void setUsers(final List<ChatUser> users) {
        this.users = users;
    }

    @Override
    public final String toString() {
        return "ResModeratorsList{" +
                "channelId='" + this.channelId + '\'' +
                ", users=" + this.users +
                '}';
    }
}
