package ru.maximkulikov.goodgame.api.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    public  final Map<String, String> getProfiles() {
        return profiles;
    }

    public  final void setProfiles( final Map<String, String> profiles) {
        this.profiles = profiles;
    }

}
