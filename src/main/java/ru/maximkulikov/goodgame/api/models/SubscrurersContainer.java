package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 03.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscrurersContainer {
    @JsonProperty("_embedded")
    private EmbededSubscribers embeded;

    @JsonProperty("page_count")
    private Long pageCount;

    @JsonProperty("page_size")
    private Long pageSize;

    @JsonProperty("total_items")
    private Long totalItems;

    private Long page;

    public final EmbededSubscribers getEmbeded() {
        return embeded;
    }

    public final void setEmbeded(final EmbededSubscribers embeded) {
        this.embeded = embeded;
    }

    public final Long getPage() {
        return this.page;
    }

    public final void setPage(final Long page) {
        this.page = page;
    }

    public final Long getPageCount() {
        return this.pageCount;
    }

    public final void setPageCount(final Long pageCount) {
        this.pageCount = pageCount;
    }

    public final Long getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
    }

    public final Long getTotalItems() {
        return this.totalItems;
    }

    public final void setTotalItems(final Long totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public final String toString() {
        return "SubscrurersContainer{" +
                "embeded=" + this.embeded +
                ", pageCount=" + this.pageCount +
                ", pageSize=" + this.pageSize +
                ", totalItems=" + this.totalItems +
                ", page=" + this.page +
                '}';
    }
}
