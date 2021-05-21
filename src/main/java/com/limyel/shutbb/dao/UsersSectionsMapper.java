package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.UsersSections;

public interface UsersSectionsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UsersSections record);

    int insertSelective(UsersSections record);

    UsersSections selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UsersSections record);

    int updateByPrimaryKey(UsersSections record);

    UsersSections selectSelective(UsersSections usersSections);

}