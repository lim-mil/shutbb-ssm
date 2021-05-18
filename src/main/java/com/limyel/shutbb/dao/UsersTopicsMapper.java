package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.UsersTopics;

public interface UsersTopicsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UsersTopics record);

    int insertSelective(UsersTopics record);

    UsersTopics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UsersTopics record);

    int updateByPrimaryKey(UsersTopics record);
}