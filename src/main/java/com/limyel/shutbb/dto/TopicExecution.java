package com.limyel.shutbb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicExecution extends Topic {
    private User user;
    private Section section;
    private Integer postNum;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private PostExecution latestPost;

    public Topic toTopic() {
        Topic topic = new Topic();
        topic.setId(getId());
        topic.setCreatedAt(getCreatedAt());
        topic.setUpdatedAt(getUpdatedAt());
        topic.setDeleted(getDeleted());
        topic.setDraft(getDraft());
        topic.setContent(getContent());
        topic.setTitle(getTitle());
        topic.setUserId(getUser().getId());
        topic.setSectionId(getSection().getId());

        return topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }

    public PostExecution getLatestPost() {
        return latestPost;
    }

    public void setLatestPost(PostExecution latestPost) {
        this.latestPost = latestPost;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
