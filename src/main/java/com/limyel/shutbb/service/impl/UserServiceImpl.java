package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.UserStatus;
import com.limyel.shutbb.dao.UserDao;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.UserService;
import com.limyel.shutbb.util.CodeUtil;
import com.limyel.shutbb.util.EmailUtil;
import com.limyel.shutbb.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private EmailUtil emailUtil;
    private RedisUtil redisUtil;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setEmailUtil(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public int create(User user) {
        user.setStatus(UserStatus.INACTIVED.getCode());
        String code = CodeUtil.getCode();
        int result = userDao.create(user);
        while (redisUtil.getRedisTemplate().opsForHash().hasKey("shutbb_active_code", code)) {
            code = CodeUtil.getCode();
        }
        redisUtil.getRedisTemplate().opsForHash().put("shutbb_active_code", code, Integer.toString(user.getId()));
        emailUtil.sendEmail(user.getEmail(), code);
        return result;
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

    @Override
    public int active(String code) {
        Object value = redisUtil.getRedisTemplate().opsForHash().get("shutbb_active_code", code);
        if (value == null) {
            return 0;
        }
        int id = Integer.parseInt((String) value);
        User user = userDao.retriveById(id);
        user.setStatus(UserStatus.NORMAL.getCode());
        redisUtil.getRedisTemplate().opsForHash().delete("shutbb_active_code", code);
        userDao.update(user);
        return 1;
    }
}
