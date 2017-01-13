package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResError implements ResChatObject {
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("error_num")
    private int errorNum; // Идентификатор ошибки, разбиты по уровням.
    private String errorMsg; // Готовое сообщение.

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(int errorNum) {
        this.errorNum = errorNum;
    }

    @Override
    public String toString() {
        return "ResError{" +
                "channelId='" + channelId + '\'' +
                ", errorNum=" + errorNum +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
