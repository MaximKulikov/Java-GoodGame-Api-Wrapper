package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 11.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqNewPollContainer implements ReqChatObject {

    private String type = "new_poll";

    private ReqNewPoll data;

    public ReqNewPollContainer(String channelId, String moderId, String moderName, String title, List<String> answers) {
        this.data = new ReqNewPoll(channelId, moderId, moderName, title, answers);
    }

    public final ReqNewPoll getData() {
        return data;
    }

    public final void setData(final ReqNewPoll data) {
        this.data = data;
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqNewPollContainer{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
