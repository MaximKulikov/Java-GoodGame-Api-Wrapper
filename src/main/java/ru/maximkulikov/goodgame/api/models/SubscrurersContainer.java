package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscrurersContainer {
    @JsonProperty("_embedded")
    private EmbededSubscribers subscribers;

    @JsonProperty("page_count")
    private Long pageCount;

    @JsonProperty("page_size")
    private Long pageSize;

    @JsonProperty("total_items")
    private Long totalItems;

    private Long page;

    /**
     * @return _embedded
     */
    public final EmbededSubscribers getSubscribers() {
        return this.subscribers;
    }

    public final void setSubscribers(final EmbededSubscribers subscribers) {
        this.subscribers = subscribers;
    }

    /**
     * @return page
     */
    public final Long getPage() {
        return this.page;
    }

    public final void setPage(final Long page) {
        this.page = page;
    }

    /**
     * @return page_count
     */
    public final Long getPageCount() {
        return this.pageCount;
    }

    public final void setPageCount(final Long pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return page_size
     */
    public final Long getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return total_items
     */
    public final Long getTotalItems() {
        return this.totalItems;
    }

    public final void setTotalItems(final Long totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public final String toString() {
        return "SubscrurersContainer{" +
                "subscribers=" + this.subscribers +
                ", pageCount=" + this.pageCount +
                ", pageSize=" + this.pageSize +
                ", totalItems=" + this.totalItems +
                ", page=" + this.page +
                '}';
    }
}
