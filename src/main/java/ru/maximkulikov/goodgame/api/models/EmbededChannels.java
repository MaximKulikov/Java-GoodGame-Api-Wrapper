package ru.maximkulikov.goodgame.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Maxim Kulikov
 * @since 18.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededChannels {

    @JsonProperty("_embedded")
    private StreamChannelContainer streams;

    @JsonProperty("page_count")
    private Integer pageCount;

    @JsonProperty("page_size")
    private Integer pageSize;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EmbededChannels that = (EmbededChannels) o;

        return new EqualsBuilder()
                .append(streams, that.streams)
                .append(pageCount, that.pageCount)
                .append(pageSize, that.pageSize)
                .append(totalItems, that.totalItems)
                .append(page, that.page)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(streams)
                .append(pageCount)
                .append(pageSize)
                .append(totalItems)
                .append(page)
                .toHashCode();
    }

    @JsonProperty("total_items")
    private Integer totalItems;

    private Integer page;

    /**
     * @return page
     */
    public final Integer getPage() {
        return this.page;
    }

    public final void setPage(final Integer page) {
        this.page = page;
    }

    /**
     * @return page_count
     */
    public final Integer getPageCount() {
        return this.pageCount;
    }

    public final void setPageCount(final Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return page_size
     */
    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return _embedded
     */
    public final List<ChannelContainer> getStreams() {
        return this.streams.getStreams();
    }

    public final void setStreams(final StreamChannelContainer streams) {
        this.streams = streams;
    }

    /**
     * @return total_items
     */
    public final Integer getTotalItems() {
        return this.totalItems;
    }

    public final void setTotalItems(final Integer totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public final String toString() {
        return "EmbededChannels{" +
                "streams=" + this.streams +
                ", pageCount=" + this.pageCount +
                ", pageSize=" + this.pageSize +
                ", totalItems=" + this.totalItems +
                ", page=" + this.page +
                '}';
    }
}
