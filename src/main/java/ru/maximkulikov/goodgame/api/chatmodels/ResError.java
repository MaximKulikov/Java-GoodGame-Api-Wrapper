package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResError resError = (ResError) o;

        return new EqualsBuilder()
                .append(channelId, resError.channelId)
                .append(errorNum, resError.errorNum)
                .append(errorMsg, resError.errorMsg)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(errorNum)
                .append(errorMsg)
                .toHashCode();
    }

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
