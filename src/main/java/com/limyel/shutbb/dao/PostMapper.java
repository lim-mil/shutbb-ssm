package com.limyel.shutbb.dao;

import com.limyel.shutbb.dto.PostExecution;
import com.limyel.shutbb.entity.Post;

import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    PostExecution selectLatestByTopicId(Long topicId);

    int countByTopicId(Long topicId);

    List<PostExecution> selectExecutionByTopicId(Long topicId);

    PostExecution selectExecutionByPrimaryKey(Long postId);

    int getFloor(Long topicId);

    List<Post> selectSelective(Post post);
}