package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GamesContainer {

    @JsonProperty("_embedded")
    private EmbededGames games;

    @JsonProperty("page_count")
    private Long pageCount;

    @JsonProperty("page_size")
    private Long pageSize;

    @JsonProperty("total_items")
    private Long totalItems;

    private Long page;

    public final EmbededGames getGames() {
        return games;
    }

    public final void setGames(final EmbededGames games) {
        this.games = games;
    }

    public final Long getPage() {
        return page;
    }

    public final void setPage(final Long page) {
        this.page = page;
    }

    public final Long getPageCount() {
        return pageCount;
    }

    public final void setPageCount(final Long pageCount) {
        this.pageCount = pageCount;
    }

    public final Long getPageSize() {
        return pageSize;
    }

    public final void setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
    }

    public final Long getTotalItems() {
        return totalItems;
    }

    public final void setTotalItems(final Long totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public final String toString() {
        return "GamesContainer{" +
                "games=" + games +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", totalItems=" + totalItems +
                ", page=" + page +
                '}';
    }
}
