package com.mb3364.twitch.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String user_id;
    private String secure;
    private String email;
    private String payments;
    private String subscribed;
    private String subscribed_stream;
    private String subscribed_anons;
    private String wallet;

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", secure='" + secure + '\'' +
                ", email='" + email + '\'' +
                ", payments='" + payments + '\'' +
                ", subscribed='" + subscribed + '\'' +
                ", subscribed_stream='" + subscribed_stream + '\'' +
                ", subscribed_anons='" + subscribed_anons + '\'' +
                ", wallet='" + wallet + '\'' +
                '}';
    }

    public String getSecure() {
        return secure;
    }

    public void setSecure(String secure) {
        this.secure = secure;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(String subscribed) {
        this.subscribed = subscribed;
    }

    public String getSubscribed_stream() {
        return subscribed_stream;
    }

    public void setSubscribed_stream(String subscribed_stream) {
        this.subscribed_stream = subscribed_stream;
    }

    public String getSubscribed_anons() {
        return subscribed_anons;
    }

    public void setSubscribed_anons(String subscribed_anons) {
        this.subscribed_anons = subscribed_anons;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
