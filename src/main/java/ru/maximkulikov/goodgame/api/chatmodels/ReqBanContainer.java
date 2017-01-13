package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 10.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqBanContainer implements ReqChatObject {
    private String type = "ban";
    private ReqBan data;

    public ReqBanContainer(String channelId, String banChannel, String userId, Long duration, String reason, String comment, Boolean show_ban) {
        this.data = new ReqBan(channelId, banChannel, userId, duration, reason, comment, show_ban);
    }

    public ReqBan getData() {
        return data;
    }

    public void setData(ReqBan data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReqBanContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
