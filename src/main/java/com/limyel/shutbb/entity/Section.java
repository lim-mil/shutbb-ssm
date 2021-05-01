package com.limyel.shutbb.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Section extends BaseModel {
    private String name;
    private User user;
    private List<Topic> topics;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
