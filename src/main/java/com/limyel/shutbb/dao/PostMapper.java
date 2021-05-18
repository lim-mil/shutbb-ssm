package com.limyel.shutbb.dao;

import com.limyel.shutbb.dto.PostExecution;
import com.limyel.shutbb.entity.Post;

public interface PostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    PostExecution selectLatestByTopicId(String topicId);

    int countByTopicId(String topicId);
}