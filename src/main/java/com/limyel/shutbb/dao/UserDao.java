package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.User;

public interface UserDao {
    int create(User user);
    User retriveById(int id);
    int update(User user);
    int deleteById(int id);
}
