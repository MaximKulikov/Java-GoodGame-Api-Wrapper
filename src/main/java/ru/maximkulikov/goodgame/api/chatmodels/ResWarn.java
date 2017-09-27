package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 10.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResWarn implements ResChatObject {

    @JsonProperty("channel_id")
    private String channelId;

    /**
     * id пользователя, кому вынесено предупреждение
     */
    @JsonProperty("user_id")
    private String userId;

    /**
     * ник забаненого пользователя
     */
    @JsonProperty("user_name")
    private String userName;

    /**
     * id пользователя, вынесшего предупреждение
     */
    @JsonProperty("moder_id")
    private String moderId;

    /**
     * ник пользователя, вынесшего бан
     */
    @JsonProperty("moder_name")
    private String moderName;

    /**
     * определяет каким цветом выводить сообщения
     */
    @JsonProperty("moder_group")
    private Long moderGroup;

    private String reason;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResWarn resWarn = (ResWarn) o;

        return new EqualsBuilder()
                .append(channelId, resWarn.channelId)
                .append(userId, resWarn.userId)
                .append(userName, resWarn.userName)
                .append(moderId, resWarn.moderId)
                .append(moderName, resWarn.moderName)
                .append(moderGroup, resWarn.moderGroup)
                .append(reason, resWarn.reason)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelId)
                .append(userId)
                .append(userName)
                .append(moderId)
                .append(moderName)
                .append(moderGroup)
                .append(reason)
                .toHashCode();
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(final String channelId) {
        this.channelId = channelId;
    }

    public final Long getModerGroup() {
        return this.moderGroup;
    }

    public final void setModerGroup(final Long moderGroup) {
        this.moderGroup = moderGroup;
    }

    public final String getModerId() {
        return this.moderId;
    }

    public final void setModerId(final String moderId) {
        this.moderId = moderId;
    }

    public final String getModerName() {
        return this.moderName;
    }

    public final void setModerName(final String moderName) {
        this.moderName = moderName;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setReason(final String reason) {
        this.reason = reason;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public final String toString() {
        return "ResWarn{" +
                "channelId='" + this.channelId + '\'' +
                ", userId='" + this.userId + '\'' +
                ", userName='" + this.userName + '\'' +
                ", moderId='" + this.moderId + '\'' +
                ", moderName='" + this.moderName + '\'' +
                ", moderGroup=" + this.moderGroup +
                ", reason='" + this.reason + '\'' +
                '}';
    }
}
