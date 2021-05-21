package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.UsersTopics;

public interface UsersTopicsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UsersTopics record);

    int insertSelective(UsersTopics record);

    UsersTopics selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UsersTopics record);

    int updateByPrimaryKey(UsersTopics record);
}