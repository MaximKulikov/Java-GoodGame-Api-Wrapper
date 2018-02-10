package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 03.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbededPremiums {

    private List<Premium> premiums;

}
