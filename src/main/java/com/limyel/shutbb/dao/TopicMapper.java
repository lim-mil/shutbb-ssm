package com.limyel.shutbb.dao;

import com.limyel.shutbb.dto.TopicExecution;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);

    List<Topic> selectByUserId(Long userId);

    List<Topic> selectDraftByUserId(Long userId);

    int deleteByLogic(@Param("id") Long id, @Param("user") User user);

    List<TopicExecution> selectExecutionSelective(Topic topic);

    TopicExecution selectExecutionByPrimaryKey(Long topicId);
}