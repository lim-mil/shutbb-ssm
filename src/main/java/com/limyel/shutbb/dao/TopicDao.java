package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Topic;

public interface TopicDao {
    int create(Topic topic);
    Topic retriveById(int id);
    int update(Topic topic);
    int deleteById(int id);
}
