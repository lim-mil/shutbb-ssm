package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.dao.UserDao;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int create(User user) {
        return userDao.create(user);
    }

    @Override
    public User retriveById(int id) {
        return userDao.retriveById(id);
    }

    @Override
    public User retrive(User user) {
        return userDao.retrive(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }
}
