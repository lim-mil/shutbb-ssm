package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.common.USERSTATUS;
import com.limyel.shutbb.dao.UserMapper;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.UserService;
import com.limyel.shutbb.util.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private EmailUtil emailUtil;
    
    @Autowired
    private RedisUtil redisUtil;
    
    @Autowired
    private ConfigUtil configUtil;
    
    @Autowired
    private AuthorizationUtil authorizationUtil;

    @Autowired
    private MiniSnow miniSnow;

    @Override
    public Response<String> create(User user, String confirmPassword, HttpServletRequest request) {
        if (!user.getPassword().equals(confirmPassword)) {
            return Response.badRequest();
        }
        // 设置默认头像
        StringBuffer url = request.getRequestURL();
        String uri = request.getRequestURI();
        String avatarURL = url.replace(url.indexOf(uri), url.length(), "/upload/shutbb/avatars/"+"default.jpg").toString();
        user.setAvatar(avatarURL);

        user.setPassword(DigestUtils.md5Hex(user.getPassword()+configUtil.getMd5Salt()));
        user.setStatus(USERSTATUS.INACTIVED.getCode());
        String code = CodeUtil.getCode();
        user.setId(miniSnow.nextId());
        int result = userMapper.insertSelective(user);
        if (result == 0) {
            return Response.badRequest();
        }

        while (redisUtil.getRedisTemplate().opsForHash().hasKey("shutbb_active_code", code)) {
            code = CodeUtil.getCode();
        }
        redisUtil.getRedisTemplate().opsForHash().put("shutbb_active_code", code, String.valueOf(user.getId()));
        emailUtil.sendEmail(user.getEmail(), code);

        return Response.success(authorizationUtil.generateJwtToken(user));
    }

    @Override
    public Response<String> login(String usernameOrEmail, String password) {
        password = DigestUtils.md5Hex(password+configUtil.getMd5Salt());
        User user = userMapper.login(usernameOrEmail, password);
        if (user != null) {
            System.out.println(password);
            return Response.success(authorizationUtil.generateJwtToken(user));
        }
        return Response.badRequestMsg("用户名、邮箱或密码错误");
    }

    @Override
    public User retriveById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User retrive(User user) {
        return userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteByLogic(id);
    }

    @Override
    public int active(String code) {
        Object value = redisUtil.getRedisTemplate().opsForHash().get("shutbb_active_code", code);
        if (value == null) {
            return 0;
        }
        Long id = (Long) value;
        User user = userMapper.selectByPrimaryKey(id);
        user.setStatus(USERSTATUS.NORMAL.getCode());
        redisUtil.getRedisTemplate().opsForHash().delete("shutbb_active_code", code);
        userMapper.updateByPrimaryKeySelective(user);
        return 1;
    }

    @Override
    public Response<String> uploadAvatar(User user, MultipartFile file, HttpServletRequest request) {
        // 上传到 webapps 目录下，防止重新部署丢失文件
        File localDir = new File(request.getServletContext().getRealPath("/"));
        String realPath = localDir.getParent() + "/upload/shutbb/avatars/";
        String filename = file.getOriginalFilename();

        // 用用户名替换文件名
        StringBuilder newFileName = new StringBuilder();
        newFileName.append(user.getUsername()).append(".");
        if (filename == null || filename.split("\\.").length != 2)
            return Response.badRequestMsg("上传失败");
        newFileName.append(filename.split("\\.")[1]);

        File targetFile = new File(realPath + newFileName.toString());

        if (!targetFile.exists()) {
            // 第一次上传头像
            StringBuffer url = request.getRequestURL();
            String uri = request.getRequestURI();
            String avatarURL = url.replace(url.indexOf(uri), url.length(), "/upload/shutbb/avatars/"+newFileName.toString()).toString();
            user.setAvatar(avatarURL);
            userMapper.updateByPrimaryKeySelective(user);
            targetFile.mkdirs();
        }

        // 上传
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            return Response.badRequestMsg("上传失败");
        }

        return Response.successMsg("上传成功");
    }


}
