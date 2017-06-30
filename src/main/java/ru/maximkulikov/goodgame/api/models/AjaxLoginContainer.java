package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Kulikov
 * @since 03.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxLoginContainer {

    private Boolean result;

    private String response;

    private Integer code;

    @JsonProperty("login_page")
    private String loginPage;

    @JsonProperty("return")
    private AjaxLoginReturn ajaxReturn;

    /**
     * @return result
     */
    public final Boolean getResult() {
        return this.result;
    }

    public final void setResult(final Boolean result) {
        this.result = result;
    }

    /**
     * @return response
     */
    public final String getResponse() {
        return this.response;
    }

    public final void setResponse(final String response) {
        this.response = response;
    }

    /**
     * @return code
     */
    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(final Integer code) {
        this.code = code;
    }

    /**
     * @return login_page
     */
    public final String getLoginPage() {
        return this.loginPage;
    }

    public final void setLoginPage(final String loginPage) {
        this.loginPage = loginPage;
    }

    /**
     * @return return
     */
    public final AjaxLoginReturn getAjaxReturn() {
        return this.ajaxReturn;
    }

    public final void setAjaxReturn(final AjaxLoginReturn ajaxReturn) {
        this.ajaxReturn = ajaxReturn;
    }

    @Override
    public final String toString() {
        return "login{" +
                "result=" + this.result +
                ", response='" + this.response + '\'' +
                ", code=" + this.code +
                ", loginPage='" + this.loginPage + '\'' +
                ", return=" + this.ajaxReturn +
                '}';
    }
}
