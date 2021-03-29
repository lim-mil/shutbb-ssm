package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int create(User user);
    User retriveById(int id);
    User retrive(User user);
    int update(User user);
    int deleteById(int id);
    User login(@Param("usernameOrEmail") String usernameOrEmail, @Param("password") String password);
}
