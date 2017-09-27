package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 08.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelsList {

    private int start;

    private int count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ReqChannelsList that = (ReqChannelsList) o;

        return new EqualsBuilder()
                .append(start, that.start)
                .append(count, that.count)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(start)
                .append(count)
                .toHashCode();
    }

    /**
     *
     * @param start
     * @param count
     */

    public ReqChannelsList(final int start, final int count) {
        this.start = start;
        this.count = count;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(final int count) {
        this.count = count;
    }

    public final int getStart() {
        return this.start;
    }

    public final void setStart(final int start) {
        this.start = start;
    }

    @Override
    public final String toString() {
        return "ReqChannelsList{" +
                "start=" + this.start +
                ", count=" + this.count +
                '}';
    }
}
