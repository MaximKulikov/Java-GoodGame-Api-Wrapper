package com.mb3364.twitch.api.models;

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

    public EmbededDonations getDonations() {
        return donations;
    }

    public void setDonations(EmbededDonations donations) {
        this.donations = donations;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public String toString() {
        return "DonationsContainer{" +
                "donations=" + donations +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", totalItems=" + totalItems +
                ", page=" + page +
                '}';
    }
}
