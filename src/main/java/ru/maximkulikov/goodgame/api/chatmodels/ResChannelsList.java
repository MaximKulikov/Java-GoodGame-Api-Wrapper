package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelsList  implements ResChatObject{
    private List<ChatChannel> channels;

    @Override
    public String toString() {
        return "ResChannelsList{" +
                "channels=" + channels +
                '}';
    }

    public List<ChatChannel> getChannels() {
        return channels;
    }

    public void setChannels(List<ChatChannel> channels) {
        this.channels = channels;
    }
}
