package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqNewPollContainer implements ReqChatObject {

    private String type = "new_poll";

    private ReqNewPoll data;

    /**
     * @param channelId channel_id
     * @param moderId   moder_id
     * @param moderName moder_name
     * @param title     title
     * @param answers   answers
     */
    public ReqNewPollContainer(final String channelId, final String moderId, final String moderName,
                               final String title, final List<String> answers) {
        this.data = new ReqNewPoll(channelId, moderId, moderName, title, answers);
    }

}
