package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 18.01.2017
 */
@Data
public class StreamChannelContainer {

    private List<ChannelContainer> streams;

}
