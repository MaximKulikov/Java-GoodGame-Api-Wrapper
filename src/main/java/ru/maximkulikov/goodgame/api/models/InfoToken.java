package ru.maximkulikov.goodgame.api.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoToken {

    private List<String> scopes;

    private String expires;

}
