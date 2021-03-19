package com.limyel.shutbb.service;

import com.limyel.shutbb.entity.User;

public interface UserService {
    int create(User user);
    User retriveById(int id);
    User retrive(User user);
    int update(User user);
    int deleteById(int id);
}
