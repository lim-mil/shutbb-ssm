package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.UsersSections;

public interface UsersSectionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UsersSections record);

    int insertSelective(UsersSections record);

    UsersSections selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UsersSections record);

    int updateByPrimaryKey(UsersSections record);
}