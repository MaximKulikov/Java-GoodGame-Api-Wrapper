package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 03.04.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxLoginReturn {

    private String id;

    private String username;

    private String avatar;

    private String token;

    private AjaxChannel channel;

    private AjaxSettings settings;

    private Integer dialogs;

    private Boolean bl;

    private String rights;

    private Boolean premium;

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public final Boolean getBl() {
        return this.bl;
    }

    public final void setBl(final Boolean bl) {
        this.bl = bl;
    }

    public final AjaxChannel getChannel() {
        return this.channel;
    }

    public final void setChannel(final AjaxChannel channel) {
        this.channel = channel;
    }

    public final Integer getDialogs() {
        return this.dialogs;
    }

    public final void setDialogs(final Integer dialogs) {
        this.dialogs = dialogs;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final Boolean getPremium() {
        return this.premium;
    }

    public final void setPremium(final Boolean premium) {
        this.premium = premium;
    }

    public final String getRights() {
        return this.rights;
    }

    public final void setRights(final String rights) {
        this.rights = rights;
    }

    public final AjaxSettings getSettings() {
        return this.settings;
    }

    public final void setSettings(final AjaxSettings settings) {
        this.settings = settings;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(final String token) {
        this.token = token;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(final String username) {
        this.username = username;
    }

    @Override
    public final String toString() {
        return "return{" +
                "id='" + this.id + '\'' +
                ", username='" + this.username + '\'' +
                ", avatar='" + this.avatar + '\'' +
                ", token='" + this.token + '\'' +
                ", channel=" + this.channel +
                ", settings=" + this.settings +
                ", dialogs=" + this.dialogs +
                ", bl=" + this.bl +
                ", rights='" + this.rights + '\'' +
                ", premium=" + this.premium +
                '}';
    }
}
