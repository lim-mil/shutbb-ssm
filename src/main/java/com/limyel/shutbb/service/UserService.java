package com.limyel.shutbb.service;

import com.limyel.shutbb.pojo.User;

public interface UserService {
    int create(User user);
    User retriveById(int id);
    int update(User user);
    int deleteById(int id);
}
