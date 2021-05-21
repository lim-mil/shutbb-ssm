package com.limyel.shutbb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostExecution extends Post {
    private User user;
    private Topic topic;
    private Post target;

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

    public Post getTarget() {
        return target;
    }

    public void setTarget(Post target) {
        this.target = target;
    }
}
