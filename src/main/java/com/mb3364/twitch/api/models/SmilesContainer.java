package com.mb3364.twitch.api.models;

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
    private Long page_count;
    private Long page_size;
    private Long total_items;
    private Long page;

    @Override
    public String toString() {
        return "SmilesContainer{" +
                "smiles=" + smiles +
                ", page_count=" + page_count +
                ", page_size=" + page_size +
                ", total_items=" + total_items +
                ", page=" + page +
                '}';
    }

    public EmbededSmiles getSmiles() {
        return smiles;
    }

    public void setSmiles(EmbededSmiles smiles) {
        this.smiles = smiles;
    }

    public Long getPage_count() {
        return page_count;
    }

    public void setPage_count(Long page_count) {
        this.page_count = page_count;
    }

    public Long getPage_size() {
        return page_size;
    }

    public void setPage_size(Long page_size) {
        this.page_size = page_size;
    }

    public Long getTotal_items() {
        return total_items;
    }

    public void setTotal_items(Long total_items) {
        this.total_items = total_items;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }
}
