package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqNewPoll {

    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("moder_id")
    private String moderId;

    @JsonProperty("moder_name")
    private String moderName;

    private String title;

    private List<PollAnswer> answers;

    /**
     * @param channelId channel_id
     * @param moderId   moder_id
     * @param moderName moder_name
     * @param title     title
     * @param answers   answers
     */
    public ReqNewPoll(final String channelId, final String moderId, final String moderName,
                      final String title, final List<String> answers) {
        this.channelId = channelId;
        this.moderId = moderId;
        this.moderName = moderName;
        this.title = title;
        List<PollAnswer> pollAnswers = new ArrayList<>();

        for (int i = 0; i < answers.size(); i++) {
            PollAnswer pollAnswer = new PollAnswer();
            pollAnswer.setId(i + 1);
            pollAnswer.setText(answers.get(i));
            pollAnswers.add(pollAnswer);
        }

        this.answers = pollAnswers;
    }

}
