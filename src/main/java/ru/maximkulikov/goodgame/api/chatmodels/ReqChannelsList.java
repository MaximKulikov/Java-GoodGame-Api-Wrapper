package ru.maximkulikov.goodgame.api.chatmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 08.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqChannelsList {
    private int start; // стартовая позиция (отсчет с 0)
    private int count; // количество каналов на страницу (max - 50)

    public ReqChannelsList(int start, int count) {
        this.start = start;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "ReqChannelsList{" +
                "start=" + start +
                ", count=" + count +
                '}';
    }
}
