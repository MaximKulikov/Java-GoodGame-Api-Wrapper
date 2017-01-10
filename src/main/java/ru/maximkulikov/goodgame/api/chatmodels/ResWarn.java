package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResWarn {
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("user_id")
    private String userId; // id пользователя, кому вынесено предупреждение
    @JsonProperty("user_name")
    private String userName; // ник забаненого пользователя
    @JsonProperty("moder_id")
    private String moderId; // id пользователя, вынесшего предупреждение
    @JsonProperty("moder_name")
    private String moderName; // ник пользователя, вынесшего бан
    @JsonProperty("moder_group")
    private Long moderGroup; // на основе группы, определяется каким цветом выводить сообщения
    private String reason;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Long getModerGroup() {
        return moderGroup;
    }

    public void setModerGroup(Long moderGroup) {
        this.moderGroup = moderGroup;
    }

    public String getModerId() {
        return moderId;
    }

    public void setModerId(String moderId) {
        this.moderId = moderId;
    }

    public String getModerName() {
        return moderName;
    }

    public void setModerName(String moderName) {
        this.moderName = moderName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ResWarn{" +
                "channelId='" + channelId + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", moderId='" + moderId + '\'' +
                ", moderName='" + moderName + '\'' +
                ", moderGroup=" + moderGroup +
                ", reason='" + reason + '\'' +
                '}';
    }
}
