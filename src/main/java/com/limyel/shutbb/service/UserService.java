package com.limyel.shutbb.service;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    Response<String> create(User user, String confirmPassword);
    Response<String> login(String usernameOrEmail, String password);
    User retriveById(int id);
    User retrive(User user);
    int update(User user);
    int deleteById(int id);
    int active(String code);
    Response<String> uploadAvatar(User user, MultipartFile file, HttpServletRequest request);
}
