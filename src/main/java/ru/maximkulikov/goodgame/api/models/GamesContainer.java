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
    private Long page_count;
    private Long page_size;
    private Long total_items;
    private Long page;


    @Override
    public String toString() {
        return "GamesContainer{" +
                "games=" + games +
                ", page_count=" + page_count +
                ", page_size=" + page_size +
                ", total_items=" + total_items +
                ", page=" + page +
                '}';
    }

    public EmbededGames getGames() {
        return games;
    }

    public Long getPage_count() {
        return page_count;
    }

    public Long getPage_size() {
        return page_size;
    }

    public Long getTotal_items() {
        return total_items;
    }

    public Long getPage() {
        return page;
    }
}
