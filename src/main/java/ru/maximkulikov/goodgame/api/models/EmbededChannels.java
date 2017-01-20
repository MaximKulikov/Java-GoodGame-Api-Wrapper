package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 18.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededChannels {

    @JsonProperty("_embedded")
    private StreamChannelContainer streams;

    @JsonProperty("page_count")
    private Integer pageCount;

    @JsonProperty("page_size")
    private Integer pageSize;

    @JsonProperty("total_items")
    private Integer totalItems;

    private Integer page;

    public final Integer getPage() {
        return this.page;
    }

    public final void setPage(final Integer page) {
        this.page = page;
    }

    public final Integer getPageCount() {
        return this.pageCount;
    }

    public final void setPageCount(final Integer pageCount) {
        this.pageCount = pageCount;
    }

    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
    }

    public final List<ChannelContainer> getStreams() {
        return this.streams.getStreams();
    }

    public final void setStreams(final StreamChannelContainer streams) {
        this.streams = streams;
    }

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
