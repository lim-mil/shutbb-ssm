package com.limyel.shutbb.entity;

public class UsersTopics extends BaseModel {
    private User user;
    private Topic topic;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
