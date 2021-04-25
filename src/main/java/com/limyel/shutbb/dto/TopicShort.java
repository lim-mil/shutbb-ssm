package com.limyel.shutbb.dto;

import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.entity.Topic;

public class TopicShort {
    private Topic topic;
    private int postNum;
    private Post latestPost;

    public TopicShort(Topic topic, int postNum, Post latestPost) {
        this.topic = topic;
        this.postNum = postNum;
        this.latestPost = latestPost;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getPostNum() {
        return postNum;
    }

    public void setPostNum(int postNum) {
        this.postNum = postNum;
    }

    public Post getLatestPost() {
        return latestPost;
    }

    public void setLatestPost(Post latestPost) {
        this.latestPost = latestPost;
    }
}
