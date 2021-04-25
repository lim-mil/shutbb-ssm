package com.limyel.shutbb.dto;

import com.limyel.shutbb.entity.Section;

import java.util.List;

public class SectionShort {
    private Section section;
    private int topicNum;
    private List<TopicShort> topics;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public int getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(int topicNum) {
        this.topicNum = topicNum;
    }

    public List<TopicShort> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicShort> topics) {
        this.topics = topics;
    }
}
