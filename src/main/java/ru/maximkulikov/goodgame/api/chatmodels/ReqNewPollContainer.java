package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 11.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqNewPollContainer implements ReqChatObject {

    private String type = "new_poll";

    private ReqNewPoll data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ReqNewPollContainer that = (ReqNewPollContainer) o;

        return new EqualsBuilder()
                .append(type, that.type)
                .append(data, that.data)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(type)
                .append(data)
                .toHashCode();
    }

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

    public final ReqNewPoll getData() {
        return this.data;
    }

    public final void setData(final ReqNewPoll data) {
        this.data = data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    @Override
    public final String toString() {
        return "ReqNewPollContainer{" +
                "type='" + this.type + '\'' +
                ", data=" + this.data +
                '}';
    }
}
