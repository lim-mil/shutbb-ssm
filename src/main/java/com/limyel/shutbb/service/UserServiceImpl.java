package com.limyel.shutbb.service;

import com.limyel.shutbb.dao.UserDao;
import com.limyel.shutbb.pojo.User;
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
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }
}
