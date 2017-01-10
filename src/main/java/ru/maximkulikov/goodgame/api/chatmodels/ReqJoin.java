package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqJoin {
    @JsonProperty("channel_id")
    private String channelId;// идентификатор канала
    private Boolean hidden;// для модераторов: не показывать ник в списке юзеров
    private Boolean mobile;// флаг с какого устройства идет подключение

    public ReqJoin(String channelId, Boolean hidden, Boolean mobile) {
        this.channelId = channelId;
        this.hidden = hidden;
        this.mobile = mobile;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "ReqJoin{" +
                "channelId='" + channelId + '\'' +
                ", hidden=" + hidden +
                ", mobile=" + mobile +
                '}';
    }
}
