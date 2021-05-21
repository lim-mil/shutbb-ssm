package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(@Param("usernameOrEmail") String usernameOrEmail, @Param("password") String password);

    int deleteByLogic(Long id);
}