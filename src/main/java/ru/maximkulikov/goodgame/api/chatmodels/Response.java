package ru.maximkulikov.goodgame.api.chatmodels;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.maximkulikov.goodgame.api.ChatResponses;

/**
 * @author Maxim Kulikov
 * @since 12.01.2017
 */
public class Response {

    private ChatResponses type;

    private ResChatObject answer;

    public Response(final ChatResponses type, final ResChatObject answer) {
        this.type = type;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        return new EqualsBuilder()
                .append(type, response.type)
                .append(answer, response.answer)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(type)
                .append(answer)
                .toHashCode();
    }

    public final ResChatObject getAnswer() {
        return this.answer;
    }

    public final ChatResponses getType() {
        return this.type;
    }
}
