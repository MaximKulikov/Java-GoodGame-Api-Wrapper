package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Maxim Kulikov
 * @since 03.04.2017
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

    /**
     * @return avatar
     */
    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return bl
     */
    public final Boolean getBl() {
        return this.bl;
    }

    public final void setBl(final Boolean bl) {
        this.bl = bl;
    }

    /**
     * @return channel
     */
    public final AjaxChannel getChannel() {
        return this.channel;
    }

    public final void setChannel(final AjaxChannel channel) {
        this.channel = channel;
    }

    /**
     * @return dialogs
     */
    public final Integer getDialogs() {
        return this.dialogs;
    }

    public final void setDialogs(final Integer dialogs) {
        this.dialogs = dialogs;
    }

    /**
     * @return id
     */
    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * @return premium
     */
    public final Boolean getPremium() {
        return this.premium;
    }

    public final void setPremium(final Boolean premium) {
        this.premium = premium;
    }

    /**
     * @return rights
     */
    public final String getRights() {
        return this.rights;
    }

    public final void setRights(final String rights) {
        this.rights = rights;
    }

    /**
     * @return settings
     */
    public final AjaxSettings getSettings() {
        return this.settings;
    }

    public final void setSettings(final AjaxSettings settings) {
        this.settings = settings;
    }

    /**
     * @return token
     */
    public final String getToken() {
        return this.token;
    }

    public final void setToken(final String token) {
        this.token = token;
    }

    /**
     * @return username
     */
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
