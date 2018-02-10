package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 18.01.2017
 */
@Data
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

}
