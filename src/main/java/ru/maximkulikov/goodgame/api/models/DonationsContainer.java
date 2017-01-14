package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DonationsContainer {

    @JsonProperty("_embedded")
    private EmbededDonations donations;

    @JsonProperty("page_count")
    private Long pageCount;

    @JsonProperty("page_size")
    private Long pageSize;

    @JsonProperty("total_items")
    private Long totalItems;

    private Long page;

    public final EmbededDonations getDonations() {
        return this.donations;
    }

    public void setDonations(final EmbededDonations donations) {
        this.donations = donations;
    }

    public final Long getPage() {
        return this.page;
    }

    public void setPage(final Long page) {
        this.page = page;
    }

    public final Long getPageCount() {
        return this.pageCount;
    }

    public void setPageCount(final Long pageCount) {
        this.pageCount = pageCount;
    }

    public final Long getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
    }

    public final Long getTotalItems() {
        return this.totalItems;
    }

    public void setTotalItems(final Long totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public String toString() {
        return "DonationsContainer{" +
                "donations=" + this.donations +
                ", pageCount=" + this.pageCount +
                ", pageSize=" + this.pageSize +
                ", totalItems=" + this.totalItems +
                ", page=" + this.page +
                '}';
    }
}
