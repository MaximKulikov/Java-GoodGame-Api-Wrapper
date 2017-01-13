package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmilesContainer {
    @JsonProperty("_embedded")
    private EmbededSmiles smiles;
    @JsonProperty("page_count")
    private Long pageCount;
    @JsonProperty("page_size")
    private Long pageSize;
    @JsonProperty("total_items")
    private Long totalItems;
    private Long page;

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

    public EmbededSmiles getSmiles() {
        return smiles;
    }

    public void setSmiles(EmbededSmiles smiles) {
        this.smiles = smiles;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public String toString() {
        return "SmilesContainer{" +
                "smiles=" + smiles +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", totalItems=" + totalItems +
                ", page=" + page +
                '}';
    }
}
