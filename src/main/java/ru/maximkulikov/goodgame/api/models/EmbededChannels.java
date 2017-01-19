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
    private StreamChannelContainer embedded;

    @JsonProperty("page_count")
    private Integer pageCount;

    @JsonProperty("page_size")
    private Integer pageSize;

    @JsonProperty("total_items")
    private Integer totalItems;

    private Integer page;

    public List<ChannelContainer> getStreams() {
        return embedded.getStreams();
    }

    public void setEmbedded(StreamChannelContainer embedded) {
        this.embedded = embedded;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public String toString() {
        return "EmbededChannels{" +
                "embedded=" + embedded +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", totalItems=" + totalItems +
                ", page=" + page +
                '}';
    }


}
