package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResError implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("error_num")
    private Integer errorNum;

    private String errorMsg;

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public final Integer getErrorNum() {
        return this.errorNum;
    }

    public final void setErrorNum(final Integer errorNum) {
        this.errorNum = errorNum;
    }

    @Override
    public final String toString() {
        return "ResError{" +
                "channelId='" + this.channelId + '\'' +
                ", errorNum=" + this.errorNum +
                ", errorMsg='" + this.errorMsg + '\'' +
                '}';
    }
}
