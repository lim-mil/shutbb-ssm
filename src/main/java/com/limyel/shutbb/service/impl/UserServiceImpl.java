package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.common.USERSTATUS;
import com.limyel.shutbb.dao.UserDao;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.UserService;
import com.limyel.shutbb.util.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private EmailUtil emailUtil;
    private RedisUtil redisUtil;
    private ConfigUtil configUtil;
    private AuthorizationUtil authorizationUtil;

    @Autowired
    public void setAuthorizationUtil(AuthorizationUtil authorizationUtil) {
        this.authorizationUtil = authorizationUtil;
    }

    @Autowired
    public void setConfigUtil(ConfigUtil configUtil) {
        this.configUtil = configUtil;
    }

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
    public Response<String> create(User user, String confirmPassword) {
        if (!user.getPassword().equals(confirmPassword)) {
            return Response.badRequest();
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()+configUtil.getMd5Salt()));
        user.setStatus(USERSTATUS.INACTIVED.getCode());
        String code = CodeUtil.getCode();
        int result = userDao.create(user);
        if (result == 0) {
            return Response.badRequest();
        }

        while (redisUtil.getRedisTemplate().opsForHash().hasKey("shutbb_active_code", code)) {
            code = CodeUtil.getCode();
        }
        redisUtil.getRedisTemplate().opsForHash().put("shutbb_active_code", code, Integer.toString(user.getId()));
        emailUtil.sendEmail(user.getEmail(), code);

        return Response.success(authorizationUtil.generateJwtToken(user));
    }

    @Override
    public Response<String> login(String usernameOrEmail, String password) {
        password = DigestUtils.md5Hex(password+configUtil.getMd5Salt());
        User user = userDao.login(usernameOrEmail, password);
        if (user != null) {
            System.out.println(password);
            return Response.success(authorizationUtil.generateJwtToken(user));
        }
        return Response.badRequestMsg("用户名、邮箱或密码错误");
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
        user.setStatus(USERSTATUS.NORMAL.getCode());
        redisUtil.getRedisTemplate().opsForHash().delete("shutbb_active_code", code);
        userDao.update(user);
        return 1;
    }
}
