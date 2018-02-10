package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PremiumsContainer {

    @JsonProperty("_embedded")
    private EmbededPremiums premiums;

    @JsonProperty("page_count")
    private Long pageCount;

    @JsonProperty("page_size")
    private Long pageSize;

    @JsonProperty("total_items")
    private Long totalItems;

    private Long page;

}
