package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelStatus {

    private Map<String, String> profiles = new HashMap<>();

    @JsonAnySetter
    public void setDynamicProperty(String name, Map<String, String> map) {
        this.profiles = map;
    }

    public Map<String, String> getProfiles() {
        return profiles;
    }

    public void setProfiles(Map<String, String> profiles) {
        this.profiles = profiles;
    }

}
