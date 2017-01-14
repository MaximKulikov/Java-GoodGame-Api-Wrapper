package ru.maximkulikov.goodgame.api.chatmodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java-GoodGame-Api-Wrapper
 * Created by maxim on 09.01.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResChannelStreamer  implements ResChatObject{

    private Long id;
    private String name;
    private Long right;
    private List<String> groups;

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRight() {
        return right;
    }

    public void setRight(Long right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "ResChannelStreamer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", right=" + right +
                ", groups=" + groups +
                '}';
    }
}
