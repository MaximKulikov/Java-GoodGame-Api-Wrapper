package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxim Kulikov
 * @since 03.04.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxLoginContainer {

    private Boolean result;

    private String response;

    private Integer code;

    @JsonProperty("login_page")
    private String loginPage;

    private String session;

    @JsonProperty("return")
    private AjaxLoginReturn ajaxReturn;

}
