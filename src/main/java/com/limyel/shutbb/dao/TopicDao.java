package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicDao {
    int create(Topic topic);
    Topic retriveById(int id);
    int update(Topic topic);
    int deleteById(@Param("id") int id, @Param("user") User user);
    List<Topic> retriveBySection(int SectionId);
    List<Topic> retriveByUser(int userId);
    List<Topic> retriveDraft(int userId);
}
