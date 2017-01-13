package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 29.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("user_id")
    private String userId;
    private String secure;
    private String email;
    private String payments;
    private String subscribed;
    @JsonProperty("subscribed_stream")
    private String subscribedStream;
    @JsonProperty("subscribed_anons")
    private String subscribedAnons;
    private String wallet;

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

    public String getSecure() {
        return secure;
    }

    public void setSecure(String secure) {
        this.secure = secure;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(String subscribed) {
        this.subscribed = subscribed;
    }

    public String getSubscribedAnons() {
        return subscribedAnons;
    }

    public void setSubscribedAnons(String subscribedAnons) {
        this.subscribedAnons = subscribedAnons;
    }

    public String getSubscribedStream() {
        return subscribedStream;
    }

    public void setSubscribedStream(String subscribedStream) {
        this.subscribedStream = subscribedStream;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", secure='" + secure + '\'' +
                ", email='" + email + '\'' +
                ", payments='" + payments + '\'' +
                ", subscribed='" + subscribed + '\'' +
                ", subscribedStream='" + subscribedStream + '\'' +
                ", subscribedAnons='" + subscribedAnons + '\'' +
                ", wallet='" + wallet + '\'' +
                '}';
    }
}
